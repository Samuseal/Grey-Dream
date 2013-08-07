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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener; 
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Board extends JPanel implements ActionListener {
	public static Ball b;
	public Player a;
	public AI c;
	public MenuMain d;
	public MenuPause e;
	public Keyprocessor k;
	private Timer timer;
	static private boolean Menumainactive= true;
	static private boolean Paused= false;
	public Board(){
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setSize(800, 400);
        addKeyListener(new TAdapter());
		b = new Ball(400,100,1,1);
		a = new Player(20,100);
		c= new AI(800,100);
		d = new MenuMain();
		e = new MenuPause();
		k=new Keyprocessor(a);
        timer = new Timer(5, this);
        timer.start();
	}
    public void addNotify() {
        super.addNotify();
    }
    public static Ball getb(){
    	return b;
    }
	public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        if (Menumainactive){
        	g2d.drawImage(d.getImage(), 40, 0, this);
        	return;
        }
        if (Paused)
        	g2d.drawImage(e.getImage(), 40, 0, this);
		g2d.drawImage(b.getImage(), b.getX(), b.getY(), this);
		g2d.drawImage(a.getImage(), a.getX(), a.getY(), this);
		g2d.drawImage(c.getImage(), c.getX(), c.getY(), this);
        g2d.setColor(Color.WHITE);
        g2d.drawString("Player U?: "+a.gets(), 5, 15);
        g2d.drawString("AI U?: "+c.gets(), 5, 30);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (Menumainactive)
			return;
		if (Paused)
			return;
		b.move();
		a.move();
		c.move();
		checkcollisions();
	}
    private void checkcollisions() {
    	Rectangle r1=b.getBounds();
    	Rectangle r2=a.getBounds();
    	Rectangle r3=c.getBounds();
    	if (r1.intersects(r2)){
    		b.bounce();
    		a.bounce();
    		b.checkup(a,c);
    	}
    	if (r1.intersects(r3)){
    		b.bounce();
    		c.bounce();
    		b.checkup(a,c);
    	}
	}
    public static boolean getpause(){
    	return Paused;
    }
    public static void setpause(boolean b){
    	Paused = b;
    }
    public static void setmenuactive(boolean b){
    	Menumainactive = b;
    }
	public class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            k.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            k.keyPressed(e);
        }
    }
}
	

