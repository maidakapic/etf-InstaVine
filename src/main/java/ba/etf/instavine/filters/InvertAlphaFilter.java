package ba.etf.instavine.filters;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;

public class InvertAlphaFilter extends ImageFilterBase  {
	
    /* (non-Javadoc)
     * @see ba.etf.instavine.filters.ImageFilterBase#applyFilter(java.awt.image.BufferedImage, java.awt.image.BufferedImage)
     */
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
 				src.setRGB(w, h, src.getRGB(w, h) ^0xff000000);
				
 			}
 		}
        return src;
    }
}
