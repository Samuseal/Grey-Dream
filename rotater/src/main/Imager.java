package main;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import java.math.*;


public class Imager {
    private String craft1 = "../Ball.png";
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private static BufferedImage image;
    public Imager(int x, int y) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft1));
    	image = (BufferedImage) ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }
    
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    
    public static BufferedImage getImage() {
        return image;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    public int getWidth(){
    	return width;
    }
    public int getHeight(){
    	return height;
    }


}

