package main;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import main.sound.SoundHandler;

public class PartShipBody {
    private String craft1 = "../Ship Body.png";
    private double x;
    private double y;
    private int width;
    private int height;
    private double dir;
    private Image image;
    private boolean leftpressed;
    private boolean rightpressed;
    private boolean moving;
    private boolean thrusting;
    private double speed;
    private final int maxspeed = 8;
    private int randomsmoke;
    public PartShipBody(int x, int y, double direction) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft1));
    	image = ii.getImage();    
        width = image.getWidth(null);
        height = image.getHeight(null);
        this.x = x;
        this.y = y;
        dir = direction;
    }
    public Image getimage(){
    	return image;        // get the image to put on the screen
    }
    public void move(){
    	if ((speed > 0))
    		moving = true; // if its not stopped, its moving :P
    	else 
    		moving = false;
    	if (leftpressed){
    		dir = dir - 0.04;  // Turn left if you press left
    		if (dir<0)
    			dir+=2*Math.PI;   // if radians are less than 0, make them 2pi bigger. just because it wont render negative rotations
    	}
    	if (rightpressed){
    		dir = dir + 0.04;  // Turn right if you press left
			if (dir>2*Math.PI)
				dir-=2*Math.PI;}  // if radians are more than 2pi, make them 2pi smaller. just because it wont render more than 2pi rotations
    	if (thrusting){
    		if (speed<maxspeed){
    			speed = speed +1;    // accelerate if you are pressing the up key
    			}
    		}else{
    			if (speed>0)
    				speed = speed - 0.04;   // if speed is more than one and your not holding one, slow down
    			if (speed<0)
    				speed=0;
    		}
    	if (moving){
    		Board.setcx((Board.getcx()+(speed*Math.cos(dir+(Math.PI/2)))),(speed*Math.cos(dir+(Math.PI/2))));
    		Board.setcy((Board.getcy()+(speed*Math.sin(dir+(Math.PI/2)))),(speed*Math.sin(dir+(Math.PI/2))));
    	}
    }
    public double getX() {
        return x;
    }
    public double getspeed(){
    	return speed;
    }
    public Rectangle getBounds() {
        return new Rectangle((int) x,(int) y, width, height);
    }
    public void setVisible(Boolean visible) {
    }
    public void leftpressed()
    {
    	leftpressed=true;
    }
    public void uppressed()
    {
    	thrusting=true;
    	SoundHandler.playSoundEngine("Engine Sound.wav");
    }
    public void upreleased()
    {
    	thrusting=false;
    }
    public int getmidx(){
        return(int)  x+(width/2);
    }
    public int getmidy(){
        return(int)  y+(height/2);
    }
    
    public void leftreleased()
    {
    	leftpressed=false;
    }
    public void rightpressed()
    {
    	rightpressed=true;
    }
    public void rightreleased()
    {
    	rightpressed=false;    
    }
    public double getY() {
        return y;
    }
    public double getdir(){
    	return dir;
    }
    public boolean getthrusting(){
    	return thrusting;
    }
}
