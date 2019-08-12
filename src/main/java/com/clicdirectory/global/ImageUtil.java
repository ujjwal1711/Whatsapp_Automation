package com.clicdirectory.global;

import org.apache.log4j.Logger;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * User: rishabh
 * Date: 28/9/16
 * Time: 6:25 AM
 */
public class ImageUtil {
    private static final Logger logger = Logger.getLogger(ImageUtil.class);

    public static BufferedImage getScaledImage(BufferedImage before, Double xScale, Double yScale) {
        int w = before.getWidth();
        int h = before.getHeight();
        BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(xScale, yScale);
        AffineTransformOp scaleOp =
                new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        return scaleOp.filter(before, after);
    }

}
