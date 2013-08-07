package main;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Player {
    private String craft1 = "../Bat.png";
    private String craft2 = "../Batbig.png";
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Image image;
    private Image image2;
    private String st;
    private boolean batb;
    private int batbcounter;
    private int dy;
    public Player(int x, int y) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft1));
    	image = ii.getImage();
        ImageIcon ib = new ImageIcon(this.getClass().getResource(craft2));
    	image2 = ib.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        this.x = x;
        this.y = y;
        st="Hello";
        batb=false;
        batbcounter = 0;
    }


    public void move() {
    	y+=dy*2;
    }

    public int getX() {
        return x;
    }
    
    public String gets(){
    	st= batb +" Number: " + batbcounter;
    	return st;
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
    	if (!batb)
        return image;
    	else 
    	return image2;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    public void uppress(){
    	dy = -1;
    }    public void downpress(){
    	dy = 1;
    }    public void uprel(){
    	dy = 0;
    }    public void downrel(){
    	dy = 0;
    }

	public void sizeu() {
		// TODO Auto-generated method stub
        batb=true;
        batbcounter = 6;
        height=image2.getHeight(null);
	}


	public void bounce() {
		// TODO Auto-generated method stub
		if (batbcounter>0){
			batbcounter--;
		}
		if (batbcounter<1){
	        if (batb){
	        y+=30;
	        height=image.getHeight(null);
	        }
	        batb=false;
		}
	}

}