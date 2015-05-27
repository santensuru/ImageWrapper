/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagewrapper;

import static imagewrapper.ImageWrapper.etaConvert;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class mainUI extends javax.swing.JFrame {
    String PATH_D;
    String PATH_I;
    private static volatile ArrayList<Pair<String, String>> DATASET = new ArrayList<>();

    /**
     * Creates new form mainUI
     */
    public mainUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        textArea1 = new java.awt.TextArea();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button1.setActionCommand("Cari Dataset");
        button1.setLabel("Cari Dataset");
        button1.setName(""); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setActionCommand("Cari Gambar");
        button2.setLabel("Cari Gambar");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setActionCommand("Mozaic");
        button3.setLabel("Mozaic");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setActionCommand("Proses Dataset");
        button4.setLabel("Proses Dataset");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        label1.setName(""); // NOI18N
        label1.setText("path dataset");

        label2.setText("path gambar");

        textArea1.setText("output");

        jProgressBar1.setName("progress"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        label2.getAccessibleContext().setAccessibleDescription("");
        textArea1.getAccessibleContext().setAccessibleName("output_progress");
        jProgressBar1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // button cari path dataset
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        jf.showOpenDialog(jf);
        
        label1.setText( jf.getSelectedFile().toString() );
        
        PATH_D = label1.getText();
    }//GEN-LAST:event_button1ActionPerformed
    
    // button generate dataset
    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        GenerateDataset dataset;
        try {
            dataset = new GenerateDataset(PATH_D, 1);
            long start = new Date().getTime();
            dataset.doInitList();
            while (dataset.doCheckThread()) {
            }
            dataset.doShortingData(false);
//            dataset.doCheckList();
            long end = new Date().getTime();
            DATASET = dataset.getDataset();
//            System.out.println(DATASET.size());
            textArea1.setText(DATASET.size() + "\r\n");
            MyDialog md = new MyDialog(new JFrame(), "minning done", ImageWrapper.etaConvert(end-start));
        } catch (IOException ex) {
            Logger.getLogger(mainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_button4ActionPerformed

    // button cari image
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        jf.showOpenDialog(jf);
        
        label2.setText( jf.getSelectedFile().toString() );
        
        PATH_I = label2.getText();
    }//GEN-LAST:event_button2ActionPerformed

    // mosaic :3
    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        long start = new Date().getTime();
        
        File input = new File(PATH_I);
//        System.out.println(PATH_I);
        BufferedImage image;
        try {
            image = ImageIO.read(input);
            int width = image.getWidth(null);
            int height = image.getHeight(null);

            // image + 1
            int partX = width / 16; //width
            int partY = height / 9; //height

            int temp;
            int R;
            int G;
            int B;
            float[] HSV = new float[3];
            float H[] = new float[(partX+1)*(partY+1)];
            float S[] = new float[(partX+1)*(partY+1)];

            Color color;
            int partHeight = height/(partY);
            int partWidth = width/(partX);

            int i, j, k, l, m=0, n=0, o;
            for (k=0; k<=partY; k++) {
                o=0;
                for (l=0; l<=partX; l++) {
                    H[m] = 0.0f;
                    S[m] = 0.0f;
                    for (i=n; i<n+partHeight && i<height; i++) {
                        for (j=o; j<o+partWidth && j<width; j++) {
                            temp = image.getRGB(j, i);
                            color = new Color(temp);
                            R = color.getRed();
                            G = color.getGreen();
                            B = color.getBlue();

                            Color.RGBtoHSB(R, G, B, HSV);

                            H[m] += (HSV[0] * HSV[1]);
                            S[m] += HSV[1];
                        }
                    }
                    o += partWidth;
                    m++;
                }
                n += partHeight;
            }
            
            // dest
            BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            m=1; n=0;
            int p, q;
            for (k=0; k<=partY; k++) {
                o=0;
                for (l=0; l<=partX; l++) {
                    String Path;
                    if (S[m-1] == 0.0f) {
                        Path = ImageWrapper.doBinarySearch(DATASET, "1.0");
                    } else {
                        Path = ImageWrapper.doBinarySearch(DATASET, String.valueOf(H[m-1] / S[m-1]));
                    }
//                    System.out.println(Path);
                    textArea1.append(Path + "\r\n");
                    File data = new File(Path);
                    BufferedImage dataInput = ImageIO.read(data);
                    BufferedImage resize;
                    resize = ImageWrapper.createResizedCopy(dataInput, partWidth, partHeight, true);

                    for (i=n, p=0; i<n+partHeight && i<height; i++, p++) {
                        for (j=o, q=0; j<o+partWidth && j< width; j++, q++) {
                            output.setRGB(j, i, 0x88 << 24 | resize.getRGB(q, p));
                        }
                    }
                    o += partWidth;
                    m++;
                    
                }
                n += partHeight;
            }
            
            // end
            BufferedImage combined = ImageWrapper.blend(image, output, 0.65);
        
            long end = new Date().getTime();

            MyDialog md = new MyDialog(new JFrame(), "matching done", ImageWrapper.etaConvert(end-start));

            JFrame frame = new JFrame();
            frame.setSize(width + 50, height + 100);

            JLabel lblimage = new JLabel(new ImageIcon(combined));

            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.add(lblimage);
            mainPanel.setAlignmentX(width/2);
            mainPanel.setAlignmentY(height/2);
            // add more components here
            frame.add(mainPanel);
            frame.setVisible(true);
            
            
        } catch (IOException ex) {
            Logger.getLogger(mainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_button3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private javax.swing.JProgressBar jProgressBar1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
