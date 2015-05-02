/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagewrapper;

import java.io.IOException;
import java.util.Date;

/**
 *
 * @author user
 */
public class ImageWrapper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        long start = new Date().getTime();
        
        GenerateDataset dataset = new GenerateDataset("C:\\cygwin64\\home\\user\\coba\\SISTER\\");
        while (dataset.doChechThread()) {
            
        }
        
        dataset.doCheckList();
        
        long end = new Date().getTime();
        
        System.out.println(end-start);
    }
    
}
