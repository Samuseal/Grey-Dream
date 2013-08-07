package Skeleton;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {
	private static final long serialVersionUID = 1718287498248147293L;
	Image sea;
	private final int WIDTH = 270;
	private final int HEIGHT = 330;
	private final int DOT_SIZE = 45;
    public Board() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("Sea.png"));
        sea = ii.getImage();
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        
        

                g2d.drawImage(sea, 10, 10, null);

    }
}