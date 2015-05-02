/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagewrapper;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class ImageWrapper {
    private static volatile ArrayList<Pair<String, String>> DATASET = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        long start = new Date().getTime();
        
        GenerateDataset dataset = new GenerateDataset("C:\\cygwin64\\home\\user\\coba\\SISTER\\");
        while (dataset.doCheckThread()) {
            
        }
        
//        dataset.doCheckList();
        
        dataset.doShortingData();
        
//        dataset.doCheckList();
        
        DATASET = dataset.getDataset();
        
        long end = new Date().getTime();
        
        System.out.println(end-start);
        
        System.out.println("minning done");
        
       File input = new File("C:\\Users\\user\\Downloads\\177660878_12119866_2460693.jpg");
//        File input = new File("C:\\Users\\user\\Downloads\\27747_129550677058587_6498350_n-edit.jpg");
        // image + 1
        int partX = 6; //width
        int partY = 6; //height
        
        BufferedImage image = ImageIO.read(input);
        
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        
        int temp;
        int R;
        int G;
        int B;
        float[] HSV = new float[3];
        float H[] = new float[(partX+1)*(partY+1)];
        
        Color color;
        
        int partHeight = height/(partY);
        int partWidth = width/(partX);
        
        int i, j, k, l, m=0, n=0, o;
        for (k=0; k<=partY; k++) {
//            n=0;
            o=0;
            for (l=0; l<=partX; l++) {
//                System.out.println(k + " " + l);
                H[m] = 0.0f;
//                o=0;
                for (i=n; i<n+partHeight && i<height; i++) {
                    for (j=o; j<o+partWidth && j<width; j++) {
                        temp = image.getRGB(j, i);
                        color = new Color(temp);
                        R = color.getRed();
                        G = color.getGreen();
                        B = color.getBlue();

                        Color.RGBtoHSB(R, G, B, HSV);

                        H[m] += HSV[0];
                    }
//                    o += partWidth;
                }
//                n += partHeight;
                o += partWidth;
                m++;
            }
//            o += partWidth;
            n += partHeight;
        }
        
//        BufferedImage output = new BufferedImage(partX, partY, BufferedImage.TYPE_INT_RGB);
//        
//        for (i=0; i<partY; i++) {
//            for (j=0; j<partX; j++) {
//                float majority = H[i*partY+j] / ( partWidth * partHeight );
//                System.out.print(majority + " ");
//                output.setRGB(j, i, Color.HSBtoRGB(majority, 1, 0.5f));
//            }
//            System.out.println("");
//        }
//        
//        JFrame frame = new JFrame();
//        frame.setSize(width, height);
//
//        JLabel lblimage = new JLabel(new ImageIcon(output));
//        
//        JPanel mainPanel = new JPanel(new BorderLayout());
//        mainPanel.add(lblimage);
//        // add more components here
//        frame.add(mainPanel);
//        frame.setVisible(true);
//        
//        BufferedImage resize = new BufferedImage(partX, partY, BufferedImage.TYPE_INT_RGB);
//        resize = createResizedCopy(image.getScaledInstance(width, height, 0), partX, partY, false);
//        
//        JFrame frame1 = new JFrame();
//        frame1.setSize(width, height);
//
//        JLabel lblimage1 = new JLabel(new ImageIcon(resize));
//        
//        JPanel mainPanel1 = new JPanel(new BorderLayout());
//        mainPanel1.add(lblimage1);
//        // add more components here
//        frame1.add(mainPanel1);
//        frame1.setVisible(true);
        
        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        m=1; n=0;
        int p, q;
        for (k=0; k<=partY; k++) {
//            n=0;
            o=0;
            for (l=0; l<=partX; l++) {
                String Path = DATASET.get(DATASET.size()-m).getLeft();
                File data = new File(Path);
                BufferedImage dataInput = ImageIO.read(data);
                BufferedImage resize = new BufferedImage(partWidth, partHeight, BufferedImage.TYPE_INT_RGB);
                resize = createResizedCopy(dataInput, partWidth, partHeight, false);
                
//                o=0;
                // lemot
                for (i=n, p=0; i<n+partHeight && i<height; i++, p++) {
                    for (j=o, q=0; j<o+partWidth && j< width; j++, q++) {
                        output.setRGB(j, i, resize.getRGB(q, p));
                        System.out.println(i + " " + j +  " " + q + " " + p);
                    }
//                    o += partWidth;
                }
//                n += partHeight;
                o += partWidth;
                System.out.println(m + " " + k + " " + l);
                m++;
            }
//            o += partWidth;
            n += partHeight;
        }
        
        JFrame frame = new JFrame();
        frame.setSize(width, height);

        JLabel lblimage = new JLabel(new ImageIcon(output));
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(lblimage);
        // add more components here
        frame.add(mainPanel);
        frame.setVisible(true);
        
    }
    
    // resize
    private static BufferedImage createResizedCopy(Image originalImage, 
    		int scaledWidth, int scaledHeight, 
    		boolean preserveAlpha) {
//    	System.out.println("resizing...");
    	int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
    	BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
    	Graphics2D g = scaledBI.createGraphics();
    	if (preserveAlpha) {
    		g.setComposite(AlphaComposite.Src);
    	}
    	g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null); 
    	g.dispose();
    	return scaledBI;
    }
    
    // copy image
    private static void copySrcIntoDstAt(final BufferedImage src,
            final BufferedImage dst, final int dx, final int dy) {
        int[] srcbuf = ((DataBufferInt) src.getRaster().getDataBuffer()).getData();
        int[] dstbuf = ((DataBufferInt) dst.getRaster().getDataBuffer()).getData();
        int width = src.getWidth();
        int height = src.getHeight();
        int dstoffs = dx + dy * dst.getWidth();
        int srcoffs = 0;
        for (int y = 0 ; y < height ; y++ , dstoffs+= dst.getWidth(), srcoffs += width ) {
            System.arraycopy(srcbuf, srcoffs , dstbuf, dstoffs, width);
        }
    }
    
}
