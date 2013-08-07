package main;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Sea {
    private String craft1 = "../Sea.png";
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Image image;
    public Sea(int x, int y) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft1));
    	image = ii.getImage();
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
    
    public Image getImage() {
        return image;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    public void move(int dx,int dy){
    	x+=dx;
    	y+=dy;
    }

}