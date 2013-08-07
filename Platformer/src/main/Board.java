package main;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Board extends JPanel implements ActionListener {

	private Timer timer;
	public Player p;
	public final int BLOCK_SIZE = 50;
	public final int SCREEN_SIZE_X = 800;
	public final int SCREEN_SIZE_Y = 400;
	private Block blist[]=new Block[SCREEN_SIZE_X/BLOCK_SIZE];
	private Block b = new Block(380,180);
	public Board(){
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setSize(SCREEN_SIZE_X, SCREEN_SIZE_Y);
        p= new Player(80,80);
        addKeyListener(new TAdapter());
        timer = new Timer(5, this);
        timer.start();
        for (int x=0; x<blist.length; x++){
        	blist[x]=new Block(x*BLOCK_SIZE,SCREEN_SIZE_Y-BLOCK_SIZE);
        }
	}
    public void addNotify() {
        super.addNotify();
    }
	public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(p.getImage(), p.getX(), p.getY(), this);
        g2d.drawString("Debug String", 5, 30);
        for (int x=0; x<blist.length; x++){
    		g2d.drawImage(blist[x].getImage(), blist[x].getX(), blist[x].getY(), this);	
        }
        g2d.drawImage(b.getImage(), b.getX(), b.getY(), this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		p.move();
		checkcollisions();
	}
	public void checkcollisions(){
		boolean contacter;
		contacter = false;
		Rectangle r1;
		r1=p.getBounds();
        for (int x=0; x<blist.length; x++){
        	if (r1.intersects(blist[x].getBounds())){
        		p.hitfloor();
        		contacter=true;
        	}
        }
    	if (r1.intersects(b.getBounds())){
    		p.hitfloor();
    		contacter=true;
    	}
        if (!contacter)
        	p.nothitfloor();
	}
	private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }
	}
}
