package main;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Player {
    private String craft1 = "../Resources/Images/Player.png";
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Image image;
    private int dx,dy;
    private boolean contact,carecontact,upheld,leftheld,rightheld;
    public Player(int x, int y) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft1));
    	image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        this.x = x;
        this.y = y;
        contact=false;
        carecontact=true;
    }


    public void move() {
    	if (carecontact)
    		if (contact)
    			dy=0;
    	if (leftheld)
    		x--;
    	if (rightheld)
    		x++;
    	y-=dy;
    	if (!contact)
    		if (dy>-2)
    			dy--;
    	if (dy<0)
    	if (!carecontact){
        	carecontact=true;
    	}
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
    public void iscontacting(){
    	carecontact=true;
    }
    public void hitfloor(){
    	contact=true;
    }
    public void nothitfloor(){
    	contact=false; 	
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            leftheld=true;
            if (rightheld)
            	rightheld=false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            rightheld=true;
            if (leftheld)
            	leftheld=false;
        }
        if (key == KeyEvent.VK_UP){
        	if (contact){
        		carecontact=false;
        		y-=3;
        		dy = 18;
        	}
            upheld=true;
        }
        	
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            leftheld=false;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            rightheld=false;
        }
        if (key == KeyEvent.VK_UP){
            upheld=false;
        }
    }
}