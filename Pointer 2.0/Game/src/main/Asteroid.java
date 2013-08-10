package main;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
public class Asteroid {
private String craft1 = "../Asteroid";
private double x;
private double y;
private int width;
private int height;
private boolean visible;
private int random;
private Image image;
public Asteroid(double x, double y) {
	random = (int) (Math.random()*9+1);
    ImageIcon ii = new ImageIcon(this.getClass().getResource(craft1+".png"));
	image = ii.getImage();
    width = image.getWidth(null);
    height = image.getHeight(null);
    visible = true;
    this.x = x;
    this.y = y;
}
public int getmidx(){
    return(int)  x+(width/2);
}
public int getmidy(){
    return(int)  y+(height/2);
}
public double getX() {
    return x;
}
public double getY() {
    return y;
}
public void explode(){
	visible = false;
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
    return new Rectangle((int)x,(int)y, width, height);
}
}