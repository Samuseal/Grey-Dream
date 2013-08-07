package main;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class PartShipCockpit {
    private String craft1 = "../Ship Cockpit.png";
    private String craft2 = "../Ship Cockpit 2.png";
    private String craft3 = "../Ship Cockpit 3.png";
    private double x;
    private double y;
    private int width;
    private int height;
    private double dir;
    private PartShipBody ship;
	private int random;
    private Image image;
    private int lengthfrom;
    public  ImageIcon i1 ;
    public  ImageIcon i2 ;
    public  ImageIcon i3 ;
    public PartShipCockpit(int x, int y, double direction,PartShipBody shipbody) {
         i1 = new ImageIcon(this.getClass().getResource(craft1));
         i2 = new ImageIcon(this.getClass().getResource(craft2));
         i3 = new ImageIcon(this.getClass().getResource(craft3));
    	random = (int)(Math.random()*3+1);
    	if (random==1){
	    	image = i1.getImage();    
    	}
    	if (random==2){
	    	image = i2.getImage();    
    	}  
    	if (random==3){
	    	image = i3.getImage();    
    	}  
    	lengthfrom = (int) (Math.random()*(60-1))-20;
        width = image.getWidth(null);
        height = image.getHeight(null);
        this.x = x-(width*2);
        this.y = y;
        dir = direction;
        ship=shipbody;
    }
    public Image getimage(){
    	return image;
    }
    public void move(){
    	x=ship.getmidx()-(width/2);
    	y=ship.getmidy()+lengthfrom;
    	dir=ship.getdir();
    }
    public double getX() {
        return x;
    }
    public Rectangle getBounds() {
        return new Rectangle((int) x,(int) y, width, height);
    }
    public int getmidx(){
        return(int)  x+(width/2);
    }
    public void regen(){
    	lengthfrom = (int) (Math.random()*(60-1))-20;
    	random = (int)(Math.random()*3+1);
    	if (random==1){
	    	image = i1.getImage();    
    	}
    	if (random==2){
	    	image = i2.getImage();    
    	}  
    	if (random==3){
	    	image = i3.getImage();    
    	}  
    }
    public int getmidy(){
        return(int)  y+(height/2);
    }
    public double getY() {
        return y;
    }
    public double getdir(){
    	return dir;
    }
    public int getlengthfrom(){
    	return lengthfrom;
    }

}
