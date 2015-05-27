/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagewrapper;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.effect.Blend;
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
     * @throws java.io.IOException
     */
//    public static void main(String[] args) throws IOException {
//        // TODO code application logic here
//        
//        int c = 16;
//        
//        long start = new Date().getTime();
//        
////        GenerateDataset dataset = new GenerateDataset("C:\\cygwin64\\home\\user\\coba\\SISTER\\");
////        GenerateDataset dataset = new GenerateDataset("C:\\Users\\user\\Pictures\\", 1);
//        GenerateDataset dataset = new GenerateDataset("C:\\Users\\user\\Downloads\\image dataset\\102flowers\\", 1);
//        
//        dataset.doInitList();
//        
//        while (dataset.doCheckThread()) {
//            
//        }
//        
////        dataset.doCheckList();
//        
//        dataset.doShortingData(false);
//        
////        dataset.doCheckList();
//        
//        DATASET = dataset.getDataset();
////        System.out.println(DATASET.size());
//        
////        for (int i=0; i<DATASET.size(); i++) {
////            System.out.println(DATASET.get(i).getLeft());
////        }
//        
//        long end = new Date().getTime();
//        
////        System.out.println(etaConvert(end-start));
//        
//        System.out.println("minning done: " + etaConvert(end-start));
//        
//        start = new Date().getTime();
//        
////        File input = new File("C:\\Users\\user\\Downloads\\177660878_12119866_2460693.jpg");
////        File input = new File("C:\\Users\\user\\Downloads\\27747_129550677058587_6498350_n-edit.jpg");
////        File input = new File("C:\\Users\\user\\Downloads\\Sunrise_over_a_Chinese_landscape_mountains.jpg");
//        File input = new File("C:\\Users\\user\\Downloads\\485022_429990987054621_128395817_n.jpg");
////        File input = new File("C:\\Users\\user\\Downloads\\EasternQingTombs_ROW7254196386_1366x768.jpg");
////        File input = new File("C:\\Users\\user\\Downloads\\Lenovo-Vibe-Z2-Pro-1.jpg");
//        
//        BufferedImage image = ImageIO.read(input);
//        
//        int width = image.getWidth(null);
//        int height = image.getHeight(null);
//        
//        // image + 1
//        int partX = width / c; //width
//        int partY = height / c; //height
//        
//        int temp;
//        int R;
//        int G;
//        int B;
//        float[] HSV = new float[3];
//        float H[] = new float[(partX+1)*(partY+1)];
//        float S[] = new float[(partX+1)*(partY+1)];
//        
//        Color color;
//        
//        int partHeight = height/(partY);
//        int partWidth = width/(partX);
//        
//        int i, j, k, l, m=0, n=0, o;
//        for (k=0; k<=partY; k++) {
////            n=0;
//            o=0;
//            for (l=0; l<=partX; l++) {
////                System.out.println(k + " " + l);
//                H[m] = 0.0f;
//                S[m] = 0.0f;
////                o=0;
//                for (i=n; i<n+partHeight && i<height; i++) {
//                    for (j=o; j<o+partWidth && j<width; j++) {
//                        temp = image.getRGB(j, i);
//                        color = new Color(temp);
//                        R = color.getRed();
//                        G = color.getGreen();
//                        B = color.getBlue();
//
//                        Color.RGBtoHSB(R, G, B, HSV);
//
//                        H[m] += (HSV[0] * HSV[1]);
//                        S[m] += HSV[1];
////                        System.out.println(k + " " + l + " " + i + " " + j);
//                    }
////                    o += partWidth;
////                    System.out.println(k + " " + l + " " + m);
//                }
////                n += partHeight;
//                o += partWidth;
//                m++;
//            }
////            o += partWidth;
//            n += partHeight;
//        }
//        
////        BufferedImage output = new BufferedImage(partX+1, partY+1, BufferedImage.TYPE_INT_RGB);
////        
////        for (i=0; i<=partY; i++) {
////            for (j=0; j<=partX; j++) {
////                float majority = H[i*(partY+1)+j] / ( partWidth * partHeight );
//////                System.out.println(i + " " + j);
////                System.out.print(majority + " ");
////                output.setRGB(j, i, Color.HSBtoRGB(majority, 1, 0.5f));
////            }
////            System.out.println("");
////        }
////        
////        JFrame frame = new JFrame();
////        frame.setSize(width, height);
////
////        JLabel lblimage = new JLabel(new ImageIcon(output));
////        
////        JPanel mainPanel = new JPanel(new BorderLayout());
////        mainPanel.add(lblimage);
////        // add more components here
////        frame.add(mainPanel);
////        frame.setVisible(true);
////        
////        BufferedImage resize = new BufferedImage(partX, partY, BufferedImage.TYPE_INT_RGB);
////        resize = createResizedCopy(image.getScaledInstance(width, height, 0), partX, partY, false);
////        
////        JFrame frame1 = new JFrame();
////        frame1.setSize(width, height);
////
////        JLabel lblimage1 = new JLabel(new ImageIcon(resize));
////        
////        JPanel mainPanel1 = new JPanel(new BorderLayout());
////        mainPanel1.add(lblimage1);
////        // add more components here
////        frame1.add(mainPanel1);
////        frame1.setVisible(true);
//        
//        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//        m=1; n=0;
//        int p, q;
////        int len = DATASET.size();
//        for (k=0; k<=partY; k++) {
////            n=0;
//            o=0;
//            for (l=0; l<=partX; l++) {
//                String Path;
//                if (S[m-1] == 0.0f) {
//                    Path = doBinarySearch(DATASET, "1.0");
//                } else {
//                    Path = doBinarySearch(DATASET, String.valueOf(H[m-1] / S[m-1]));
//                }
////                String Path = doBinarySearch(DATASET, String.valueOf(H[m-1] / ( partWidth * partHeight )));
////                String Path = DATASET.get(len-m).getLeft();
////                System.out.println(len + " " + m + " " + Path);
//                File data = new File(Path);
//                BufferedImage dataInput = ImageIO.read(data);
//                BufferedImage resize;// = new BufferedImage(partWidth, partHeight, BufferedImage.TYPE_INT_ARGB);
//                resize = createResizedCopy(dataInput, partWidth, partHeight, true);
//                
////                o=0;
//                // lemot
//                for (i=n, p=0; i<n+partHeight && i<height; i++, p++) {
//                    for (j=o, q=0; j<o+partWidth && j< width; j++, q++) {
//                        output.setRGB(j, i, 0x88 << 24 | resize.getRGB(q, p));
////                        System.out.println(i + " " + j +  " " + q + " " + p);
//                    }
////                    o += partWidth;
//                }
////                n += partHeight;
//                o += partWidth;
////                System.out.println(m + " " + k + " " + l);
//                m++;
////                if (len-m < 0) {
////                    m=1;
////                }
////                System.out.println(m);
//            }
////            o += partWidth;
//            n += partHeight;
//        }
//        
////        BufferedImage tempOutput = ImageToBufferedImage(TransformColorToTransparency(output, Color.WHITE, Color.BLACK), width, height);
//        
////        //combined
////        BufferedImage combined = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
////
////        // paint both images, preserving the alpha channels
////        Graphics g = combined.getGraphics();
////        g.drawImage(image, 0, 0, null);
////        g.drawImage(output, 0, 0, null);
//        
//        BufferedImage combined = blend(image, output, 0.65);
//        
//        end = new Date().getTime();
//        
//        System.out.println("matching done: " + etaConvert(end-start));
//        
//        JFrame frame = new JFrame();
//        frame.setSize(width + 50, height + 100);
//
//        JLabel lblimage = new JLabel(new ImageIcon(combined));
//        
//        JPanel mainPanel = new JPanel(new BorderLayout());
//        mainPanel.add(lblimage);
//        mainPanel.setAlignmentX(width/2);
//        mainPanel.setAlignmentY(height/2);
//        // add more components here
//        frame.add(mainPanel);
//        frame.setVisible(true);
//        
//    }
    
    // resize
    public static BufferedImage createResizedCopy(Image originalImage, 
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
    
    // binary search
    public static String doBinarySearch(ArrayList<Pair<String, String>> a, String b) {
        if (a.isEmpty()) {
            return "";
        }
        int low = 0;
        int high = a.size()-1;
        int middle = 0; 
        
        while(low <= high) {
            middle = (low+high) /2;
            if ( Float.valueOf(b) > Float.valueOf(a.get(middle).getRight() ) ){
                low = middle +1;
            } else if ( Float.valueOf(b) < Float.valueOf(a.get(middle).getRight() ) ){
                high = middle -1;
            } else { // The element has been found
//                System.out.println(a.get(middle).getRight() + " " + b);
                return a.get(middle).getLeft(); 
            }
        }
//        System.out.println(a.get(middle).getRight() + " " + b);
        return a.get(middle).getLeft();
    }
    
    // fast copy image
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
    
    public static String etaConvert(long l_d) {
        String eta = "";
        long ms = l_d % 1000;
        l_d /= 1000;
        if (l_d >= 86400) {
            eta += String.valueOf(l_d/86400) + " d ";
            l_d %= 86400;
        }
        if (l_d >= 3600) {
            eta += String.valueOf(l_d/3600) + " h ";
            l_d %= 3600;
        }
        if (l_d >= 60) {
            eta += String.valueOf(l_d/60) + " m ";
            l_d %= 60;
        }
        eta += String.valueOf(l_d) + "." + String.valueOf(ms) + " s";
        return eta;
    }
    
    private static Image TransformColorToTransparency(BufferedImage image, Color c1, Color c2)
    {
        // Primitive test, just an example
        final int r1 = c1.getRed();
        final int g1 = c1.getGreen();
        final int b1 = c1.getBlue();
        final int r2 = c2.getRed();
        final int g2 = c2.getGreen();
        final int b2 = c2.getBlue();
        ImageFilter filter = new RGBImageFilter()
        {
            public final int filterRGB(int x, int y, int rgb)
            {
                int r = (rgb & 0xFF0000) >> 16;
                int g = (rgb & 0xFF00) >> 8;
                int b = rgb & 0xFF;
                if (r >= r1 && r <= r2 &&
                    g >= g1 && g <= g2 &&
                    b >= b1 && b <= b2)
                {
                    // Set fully transparent but keep color
                    return rgb & 0xFFFFFF;
                }
                return rgb;
            }
        };

        ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }

    private static BufferedImage ImageToBufferedImage(Image image, int width, int height)
    {
        BufferedImage dest = new BufferedImage(
            width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = dest.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return dest;
    }
    
    public static BufferedImage blend (BufferedImage bi1, BufferedImage bi2,
                double weight)
    {
        if (bi1 == null)
            throw new NullPointerException ("bi1 is null");

        if (bi2 == null)
            throw new NullPointerException ("bi2 is null");

        int width = bi1.getWidth ();
        if (width != bi2.getWidth ())
            throw new IllegalArgumentException ("widths not equal");

        int height = bi1.getHeight ();
        if (height != bi2.getHeight ())
            throw new IllegalArgumentException ("heights not equal");

        BufferedImage bi3 = new BufferedImage (width, height,
                            BufferedImage.TYPE_INT_RGB);
        int [] rgbim1 = new int [width];
        int [] rgbim2 = new int [width];
        int [] rgbim3 = new int [width];

        for (int row = 0; row < height; row++)
        {
            bi1.getRGB (0, row, width, 1, rgbim1, 0, width);
            bi2.getRGB (0, row, width, 1, rgbim2, 0, width);

            for (int col = 0; col < width; col++)
            {
                int rgb1 = rgbim1 [col];
                int r1 = (rgb1 >> 16) & 255;
                int g1 = (rgb1 >> 8) & 255;
                int b1 = rgb1 & 255;

                int rgb2 = rgbim2 [col];
                int r2 = (rgb2 >> 16) & 255;
                int g2 = (rgb2 >> 8) & 255;
                int b2 = rgb2 & 255;

                int r3 = (int) (r1*weight+r2*(1.0-weight));
                int g3 = (int) (g1*weight+g2*(1.0-weight));
                int b3 = (int) (b1*weight+b2*(1.0-weight));
                rgbim3 [col] = (r3 << 16) | (g3 << 8) | b3;
            }

            bi3.setRGB (0, row, width, 1, rgbim3, 0, width);
        }

        return bi3;
    }
}
