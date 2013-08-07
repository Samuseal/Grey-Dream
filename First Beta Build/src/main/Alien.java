package main;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Alien {

    private String craft = "alien.png";
    private String deathimg = "explotion.png";
    private int x;
    private int y;
    private int width;
    private int expltmr;
    private int height;
    private boolean visible;
    private boolean exploding;
    private Image image;
    private Image death;
    public Alien(int x, int y) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        ImageIcon expl = new ImageIcon(this.getClass().getResource(deathimg));
        death = expl.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        this.x = x;
        this.y = y;
    }


    public void move() {
        if (x < 0) 
            x = 400;
        x -= 1;
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
    
    public boolean isExploding() {
        return exploding;
    }

    public boolean isexpltmr() {
    	if (expltmr<0){
    		return true;
    	}
    	else return false;
    }
    
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    
    public void changeexplodetimer() {
        this.expltmr--;
    }
    
    public void setExploding(Boolean exploding) {
        this.exploding = exploding;
    }
    
    public void setExpltmr(int size) {
        this.expltmr = size;
    }
    
    public Image getImage() {
        return image;
    }
    
    public Image getImageexplotion() {
        return death;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }


}
