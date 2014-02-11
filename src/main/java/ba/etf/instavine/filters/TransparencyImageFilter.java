package ba.etf.instavine.filters;

import java.awt.image.*;


public class TransparencyImageFilter extends ImageFilterBase  {
    public BufferedImage applyFilter(BufferedImage src, BufferedImage dst) {
    	
    	 if (dst == null)
             dst = createCompatibleDestImage(src, null);
         final int width = src.getWidth();
         final int height = src.getHeight();
                 
         int markerRGB = src.getRGB(0, 0) | 0xFF000000; 
         for(int w = 0; w < width ; w++)		

	  		{			
	
	  			for(int h = 0 ; h <height ; h++)			
	
	  			{
			         int rgb = src.getRGB(w, h);
			        
			         if ((rgb | 0xFF000000) == markerRGB)  
			         {  
			            // Mark the alpha bits as zero - transparent  
			            dst.setRGB(w, h, 0x00FFFFFF & rgb);  
			         }  
			         else  
			         {  
			            // nothing to do  
			            dst.setRGB(w, h, rgb);			            
			         }  
	  			}}
         return dst;
    }
}