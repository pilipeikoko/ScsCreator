package org.bsuir.scs.image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageResizer {
    public static BufferedImage resize(BufferedImage img, int newWidth, int newHeight) {
        Image tempImage = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage result = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = result.createGraphics();
        g2d.drawImage(tempImage, 0, 0, null);
        g2d.dispose();

        return result;
    }
}
