package main;

import java.awt.event.KeyEvent;

public class Scroller {
    public String craft1 = "Test!";
    private int x;
    private int y;
    private int dx;
    private int dy;
    private boolean visible;
    public Scroller(int nx, int ny) {
        visible = true;
        x=(nx);
        y=(ny);
    }
    public void move() {
        x += dx;
        y += dy;
        if (x < 1) {
            x = 1;}
        if (y < 1) {
            y = 1;
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
    
    public String getImage() {
        return craft1;
    }
    public void setstring(String text){
    	craft1=text;
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }
        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }      
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        if (key == KeyEvent.VK_ENTER) {
        }   
    }
}
