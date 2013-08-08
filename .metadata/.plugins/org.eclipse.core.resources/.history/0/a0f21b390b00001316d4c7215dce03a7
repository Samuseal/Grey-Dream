package main;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
public class Planet {
private String craft1 = "../planetimg";
private double x;
private double y;
private int width;
private int height;
private boolean visible;
private String name;
private int random;
private Image image;
public Planet(double x, double y, String namer) {
	random = (int) (Math.random()*9+1);
    ImageIcon ii = new ImageIcon(this.getClass().getResource(craft1+random+".png"));
	image = ii.getImage();
    width = image.getWidth(null);
    height = image.getHeight(null);
    visible = true;
    this.x = x;
    this.y = y;
    String input = namer;
    name = input.substring(0, 1).toUpperCase() + input.substring(1);
}

public double getX() {
    return x;
}
public String getname(){
	return name;
}
public double getY() {
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
    return new Rectangle((int)x,(int)y, width, height);
}
}
