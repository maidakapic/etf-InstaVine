package ba.etf.instavine.filters;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.color.ColorSpace;

public class NegativeFilter extends ImageFilterBase  {
    public BufferedImage applyFilter(BufferedImage src, BufferedImage dst) {
    	
    	 if (dst == null)
             dst = createCompatibleDestImage(src, null);
         final int width = src.getWidth();
         final int height = src.getHeight();
         
         for(int w = 0; w < width ; w++)		

 		{			

 			for(int h = 0 ; h <height ; h++)			

 			{
 				Color color = new Color(src.getRGB(w, h));
				
				int newRed=255-color.getRed() ;
				int newGreen=255-color.getGreen();
				int newBlue=255-color.getBlue();
				
				Color lookup = new Color(newRed, newGreen, newBlue);
				
				dst.setRGB(w, h, lookup.getRGB()); 	
 				
 				
 			}
 		}
    	
    	    	
        return dst;
    }
}