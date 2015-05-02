/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagewrapper;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author user
 */
public class GenerateDataset {
    private static File ROOTPATH;
    private static volatile ArrayList<Pair<String, String>> DATASET = new ArrayList<>();
    private static ArrayList<Thread> THREADS = new ArrayList<>();
    
    public GenerateDataset(String path) throws IOException {
        ROOTPATH = new File(path);
        
        // generate dataset
//        doListDataset(ROOTPATH);
        Thread task = new doListDatasetThread(ROOTPATH);
        task.setName(ROOTPATH.getAbsolutePath());
        THREADS.add(task);
        task.start();
    }
    
    private void doListDataset(final File folder) throws IOException {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                Thread task = new doListDatasetThread(fileEntry);
                task.setName(fileEntry.getAbsolutePath());
                THREADS.add(task);
                task.start();
//                doListDataset(fileEntry);
//                System.out.println(fileEntry.getAbsolutePath());
            } else if (fileEntry.getName().contains(".jpg") || fileEntry.getName().contains(".png")) {
                String color = doCheckColor(fileEntry);
                DATASET.add(new Pair(fileEntry.getAbsolutePath(), color));
//                System.out.println(fileEntry.getAbsolutePath() + " " + color);
            }
        }
    }
    
    private class doListDatasetThread extends Thread {
        private File folder;
        
        doListDatasetThread(final File folder) {
            this.folder = folder;
//            System.out.println(folder.getAbsolutePath());
        }
        
        @Override
        public void run() {
            try {
                doListDataset(folder);
            } catch (IOException ex) {
                Logger.getLogger(GenerateDataset.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private String doCheckColor(final File raw) throws IOException {
        BufferedImage image = ImageIO.read(raw);
        
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        
        int temp;
        int R;
        int G;
        int B;
        float[] HSV = new float[3];
        float H = 0.0f;
        
        Color color;
        
        int i, j;
        for (i=0; i<height; i++) {
            for (j=0; j<width; j++) {
                temp = image.getRGB(j, i);
                color = new Color(temp);
                R = color.getRed();
                G = color.getGreen();
                B = color.getBlue();
                
                Color.RGBtoHSB(R, G, B, HSV);
                
                H += HSV[0];
            }
        }
        
        float majority = H / ( width * height );
        
        return String.valueOf(majority);
    }
    
    public void doCheckList() {
        int i;
        for (i=0; i<DATASET.size(); i++) {
            System.out.println(DATASET.get(i).getLeft() + " " + DATASET.get(i).getRight());
        }
        
        System.out.println(DATASET.size());
    }
    
    public boolean doChechThread() {
        int i;
        for (i=0; i<THREADS.size(); i++) {
            Thread current = THREADS.get(i);
//            System.out.println(current.getName());
            
            if (current.isAlive())
                return true;
            else
                THREADS.remove(i);
        }
        return false;
    }
}
