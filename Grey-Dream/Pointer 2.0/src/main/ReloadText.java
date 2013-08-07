package main;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class ReloadText {
    private String craft1 = "../Reloading.png";
    private double x;
    private double y;
    private int width;
    private int height;
    private double dir;
    private boolean visible;
    private PartShipBody ship;
    private Laser laser;
    private Image image;
    private int lengthfrom;
    public ReloadText(int x, int y, Laser las) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft1));
    	image = ii.getImage();    
    	lengthfrom = (int) (Math.random()*(80-1))-40;
        width = image.getWidth(null);
        height = image.getHeight(null);
        this.x = Board.Screensizeh-width;
        this.y = 0;
        laser=las;
    }
    public Image getimage(){
    	return image;
    }
    public void update(){
    	if (laser.getreloading())
    		visible = true;
    	else
    		visible = false;
    }
    public double getX() {
        return x;
    }
    public Rectangle getBounds() {
        return new Rectangle((int) x,(int) y, width, height);
    }
    public double getY() {
        return y;
    }
    public void setvisible(boolean s){
    	visible = s;
    }
    public boolean getvisible(){
    	return visible;
    }

}