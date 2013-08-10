package main;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
public class Star {
private int random;
private String craft1 = "../Star1.png";
private String craft2 = "../Star2.png";
private String craft3 = "../Star3.png";
private String craft4 = "../Star4.png";
private String craft5 = "../Star5.png";
private double x;
private double y;
private int width;
private int height;
private boolean visible;
private boolean onscreen;
private Image image;
private boolean isslowstar;
private int movetime;
private int Min,Max;
public Star(double x, double y) {
	Min = 1;
	isslowstar = false;
	Max = 7;
	random = Math.round(Min + (int)(Math.random() * ((Max - Min) + 1)));
	if (random == 1){
    ImageIcon ii = new ImageIcon(this.getClass().getResource(craft1));
	image = ii.getImage();
	isslowstar = true;} // gray thus further away :D
	else if (random == 2){
	ImageIcon ii = new ImageIcon(this.getClass().getResource(craft2));
    image = ii.getImage();
	isslowstar = true;} // also gray thus further away :D}	
	else if (random == 3){
	ImageIcon ii = new ImageIcon(this.getClass().getResource(craft5));
    image = ii.getImage();}	
	else if (random == 4){
	ImageIcon ii = new ImageIcon(this.getClass().getResource(craft4));
    image = ii.getImage();}	
	else{
    	ImageIcon ii = new ImageIcon(this.getClass().getResource(craft3));
        image = ii.getImage();}	
    width = image.getWidth(null);
    height = image.getHeight(null);
    visible = true;
    this.x = x;
    this.y = y;
	x=(Math.random()*2000)-1000+Board.getcx()+(Board.Screensizeh/2);
	y=(Math.random()*2000)-1000+Board.getcy()+(Board.Screensizev/2);
    movetime = 1;
}


public void move() {
	if ((x>Board.getcx())&&(y>Board.getcy())&&(x<Board.getcx()+Board.Screensizeh)&&(y<Board.getcy()+Board.Screensizev)){
		onscreen=true;
	} else {
		onscreen = false;
	}
	if (!onscreen){
		x=(Math.random()*2000)-1000+Board.getcx()+(Board.Screensizeh/2);
		y=(Math.random()*2000)-1000+Board.getcy()+(Board.Screensizev/2);
	}
}

public double getX() {
    return x;
}
public boolean getonscreen() {
    return onscreen;
}

public double getY() {
    return y;
}
public void starx(double xadd){
	x+=xadd;
}
public void stary(double yadd){
	y+=yadd;
}
public boolean getslowstar(){
	return isslowstar;
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


