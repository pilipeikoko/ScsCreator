package org.bsuir.scs.image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageCreator {
    public static BufferedImage resize(BufferedImage img, int newWidth, int newHeight) {
        Image tempImage = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage result = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = result.createGraphics();
        g2d.drawImage(tempImage, 0, 0, null);
        g2d.dispose();

        return result;
    }

    public static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }
}
