package ba.etf.instavine.filters;

import java.awt.image.*;

public class InvertFilter extends ImageFilterBase  {
    public BufferedImage applyFilter(BufferedImage src, BufferedImage dst) {
    	int height = src.getHeight();
        int width = src.getWidth();
        for(int h=1; h < height-1; h++)
                {
                    for(int w=1; w < width-1;w++)
                    {
                        float color = ((1f/9f*src.getRGB(w-1, h-1))+(1f/9f* src.getRGB(w, h-1))+(1f/9f* src.getRGB(w+1, h-1))+
                                    +(1f/9f* src.getRGB(w-1, h))+(1f/9f* src.getRGB(w, h))+(1f/9f* src.getRGB(w+1, h))+
                                    (1f/9f* src.getRGB(w-1, h+1))-(1f/9f* src.getRGB(w, h+1))-(1f/9f* src.getRGB(w+1, h+1)));
                        src.setRGB( w, h,(int)color);   
                    }
                }
    	
        return src;
    }
}