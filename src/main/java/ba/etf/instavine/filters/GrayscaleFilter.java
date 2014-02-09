package ba.etf.instavine.filters;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;

public class GrayscaleFilter extends ImageFilterBase  {
	
    public BufferedImage applyFilter(BufferedImage src, BufferedImage dst) {
        if (src.getType() == BufferedImage.TYPE_BYTE_GRAY)
        {
            dst = src;
            return dst;
        }

        if (dst == null)
            dst = createCompatibleDestImage(src, null);
        final int width = src.getWidth();
        final int height = src.getHeight();
        
        for(int w = 0; w < width ; w++)		

		{			

			for(int h = 0 ; h <height ; h++)			

			{
				Color color = new Color(src.getRGB(w, h));
				
				int averageColor = ((color.getRed() + color.getGreen() + color.getBlue()) / 3);				
				Color avg = new Color(averageColor, averageColor, averageColor);
				dst.setRGB(w, h, avg.getRGB());
				
			}
			}				
        
        return dst;
    }
    
   
}