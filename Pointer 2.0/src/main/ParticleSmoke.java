package main;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
public class ParticleSmoke {
private int random;
private String craft1 = "../Star3.png";
private double x;
private double y;
private int width;
private int height;
private boolean visible;
private Image image;
private int movetime;
private int Min,Max;
public ParticleSmoke(double x, double y) {
    ImageIcon ii = new ImageIcon(this.getClass().getResource(craft1));
	image = ii.getImage();
    width = image.getWidth(null);
    height = image.getHeight(null);
    visible = true;
    this.x = x;
    this.y = y;
    movetime = 1;
}

public double getX() {
    return x;
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
