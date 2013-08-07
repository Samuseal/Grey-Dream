package main;

import java.awt.event.KeyEvent;

public class Keyhandler {
	int MAPXSIZE;
	int MAPYSIZE;
	public Keyhandler(int mapx , int mapy){
		MAPXSIZE = mapx; MAPYSIZE = mapy;
	}
	
	public void keyPresseds(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
 		    Board.uppress();
        }
        if (key == KeyEvent.VK_DOWN) {
        	Board.downpress();
        }
        if (key == KeyEvent.VK_LEFT) {
        	Board.leftpress();
        }
        if (key == KeyEvent.VK_RIGHT) {
        	Board.rightpress();
        }
    }
	

	public void keyReleaseds(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
        	Board.uprel();
        }

        if (key == KeyEvent.VK_DOWN) {
        	Board.downrel();
        }
        if (key == KeyEvent.VK_LEFT) {
        	Board.leftrel();
        }
        if (key == KeyEvent.VK_RIGHT) {
        	Board.rightrel();
        }
	}

}
