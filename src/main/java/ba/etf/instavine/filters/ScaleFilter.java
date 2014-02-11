package ba.etf.instavine.filters;

import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.io.IOException;

public class ScaleFilter extends ImageFilterBase  {
    public BufferedImage applyFilter(BufferedImage src, BufferedImage dst) {
    	if (dst == null)
            dst = createCompatibleDestImage(src, null);
    	
        final int width = src.getWidth()/2;
        final int height = src.getHeight()/2;
        
        try {
			dst = scale(src,width, height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return dst;
        
    }

public static BufferedImage scale(BufferedImage src, int width, int height) throws IOException {
    BufferedImage dest = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D g = dest.createGraphics();
    AffineTransform at = AffineTransform.getScaleInstance(
            (double)width/src.getWidth(),
            (double)height/src.getHeight());
    g.drawRenderedImage(src,at);        
    return dest;
} }