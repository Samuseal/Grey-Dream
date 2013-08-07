package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;
public class Board extends JPanel implements ActionListener {

	private Timer timer;
	public final int BLOCK_SIZE = 50;
	public final int SCREEN_SIZE_X = 800;
	public final int SCREEN_SIZE_Y = 400;
	public BufferedImage image;
	public Board(){
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setSize(SCREEN_SIZE_X, SCREEN_SIZE_Y);
        timer = new Timer(5, this);
        timer.start();
        image = Imager.getImage();
	}
    public void addNotify() {
        super.addNotify();
    }
	public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
		// The required drawing location
		int drawLocationX = 300;
		int drawLocationY = 300;

		// Rotation information

		double rotationRequired = Math.toRadians(45);
		double locationX = image.getWidth() / 2;
		double locationY = image.getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

		// Drawing the rotated image at the required drawing locations
		g2d.drawImage(op.filter(image, null), drawLocationX, drawLocationY, null);
		g.setColor(Color.yellow);
        g2d.drawString("Debug String", 5, 30);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
}
