package main;
import java.awt.Color;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 3249716937809828864L;
    private final static int MAPXSIZE = 50;
    private final static int MAPYSIZE = 50;
    private final static int TILESIZE = 45;
    private final static int MINMAPSIZE = 4;
    private final static int MINMAPTOX = 1290-4-MINMAPSIZE*MAPXSIZE;
    private final static int MINMAPTOY = 740-8-MINMAPSIZE*MAPYSIZE;
    private final static int MINSCREENHEIGHT = 1290/(TILESIZE/MINMAPSIZE);
    private final static int  MINSCREENWIDTH = 760/(TILESIZE/MINMAPSIZE);
    private static Object pos[][] = new Object[MAPXSIZE][MAPYSIZE];
    private static Object newpos[][] = new Object[MAPXSIZE][MAPYSIZE];
    private double r;
    public int currentFPS = 0;
    public int FPS = 0;
    public long start = 0;
	private static boolean up,down,left,right;
    private Keyhandler keyhandler;
    private int camtopx,camtopy;
    private int B_WIDTH,B_HEIGHT;
    private static String fpsmsg;
	private Timer timer;
	public Board(){
        keyhandler = new Keyhandler(MAPXSIZE,MAPYSIZE);
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(new TAdapter());
        clearnewpos();
		for (int i=0; i < MAPXSIZE; i++)
			   for (int j=0; j < MAPYSIZE; j++){
				  r=randomh(1,100);
				  if (!(r==1)){
					  pos[i][j] = new Sea(i,j);
			      } else {
					  pos[i][j]= new Land(i,j);
				  }
				  }
		biggerislands(7);
		watertileremover();
		beachsetter();
		camtopx = 0;
		camtopy = 0;
        timer = new Timer(30, this);
        timer.start();
	}
    public void addNotify() {
        super.addNotify();
        B_WIDTH = getWidth();
        B_HEIGHT = getHeight();  
    }
	public void newpos2screenpos(){
		for (int x=0;x<MAPXSIZE;x++){
			for (int y=0;y<MAPYSIZE;y++){
				if (newpos[x][y] instanceof Sea){
					pos[x][y]= new Sea(x,y);
				} else if (newpos[x][y] instanceof Land){
					pos[x][y]= new Land(x,y);					
				} else if (newpos[x][y] instanceof Beach){
					pos[x][y]= new Beach(x,y);		
					
			}}}
		
	}
	public void watertileremover(){
		int touch;
		for (int i=0; i < MAPXSIZE; i++){
			   for (int j=0; j < MAPYSIZE; j++){
				   if ((i>0) && (i<(MAPXSIZE-1)) && (j>0) && (j<(MAPYSIZE-1))){
						if (pos[i][j] instanceof Sea){
						   touch = 0;
					   	   if ((pos[i+1][j] instanceof Land))
							   touch++;
						   if ((pos[i-1][j] instanceof Land))
							   touch++;
						   if ((pos[i][j+1] instanceof Land))
							   touch++;
						   if ((pos[i][j-1] instanceof Land))
							   touch++;
						   if (touch==4)
							   pos[i][j]=new Land(i,j);
						}
				   }
			   }
			}
	}
	public void biggerislands(int loopnum){
		int randomn;
		for (int x=0; x<loopnum; x++){
		for (int i=0; i < MAPXSIZE; i++){
			   for (int j=0; j < MAPYSIZE; j++){
				   if ((i>0) && (i<(MAPXSIZE-1)) && (j>0) && (j<(MAPYSIZE-1))){
					   if (pos[i][j] instanceof Sea){
						   randomn=randomh(1,10);
						   if ((pos[i+1][j] instanceof Land)&&(randomn<7)){
							   newpos[i][j]= new Land(i,j);
						   }
						   if ((pos[i-1][j] instanceof Land)&&(randomn<7)){
							   newpos[i][j]= new Land(i,j);
						   }
						   if ((pos[i][j+1] instanceof Land)&&(randomn<7)){
							   newpos[i][j]= new Land(i,j);
						   }
						   if ((pos[i][j-1] instanceof Land)&&(randomn<7)){
							   newpos[i][j]= new Land(i,j);
						   }
					   }else {
						   newpos[i][j]= new Land(i,j);
					   }
				   }  
			   }
		}	newpos2screenpos();
		}	
	}
	public void clearnewpos(){
		for (int i=0; i < MAPXSIZE; i++){
			   for (int j=0; j < MAPYSIZE; j++){
				   newpos[i][j] = new Sea(i,j);
			   }
		}
	}
	public void beachsetter(){
		clearnewpos();
		for (int i=0; i < MAPXSIZE; i++){
			   for (int j=0; j < MAPYSIZE; j++){
				   if ((i>0) && (i<(MAPXSIZE-1)) && (j>0) && (j<(MAPYSIZE-1))){
					   if (pos[i][j] instanceof Land){
						   if ((pos[i+1][j] instanceof Sea)){
							   newpos[i][j]= new Beach(i,j);
						   }
						   if ((pos[i-1][j] instanceof Sea)){
							   newpos[i][j]= new Beach(i,j);
						   }
						   if ((pos[i][j+1] instanceof Sea)){
							   newpos[i][j]= new Beach(i,j);
						   }
						   if ((pos[i][j-1] instanceof Sea)){
							   newpos[i][j]= new Beach(i,j);
						   }
					   }	else{
						   newpos[i][j]= new Land(i,j);
					   }				   
				   	   }
				   }
			   } newpos2screenpos();clearnewpos();
	}
	public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
		for (int i=0;i<pos.length;i++){
			for (int f=0;f<pos[i].length;f++){ 
				if (pos[i][f] instanceof Sea){
					Sea s = (Sea)pos[i][f];
	                g2d.drawImage(s.getImage(), i*TILESIZE+camtopx, (f*TILESIZE)+camtopy, this);
				}
				else if(pos[i][f] instanceof Land){
					Land s = (Land)pos[i][f];
	                g2d.drawImage(s.getImage(), i*TILESIZE+camtopx, (f*TILESIZE)+camtopy, this);
				}
				else if(pos[i][f] instanceof Beach){
					Beach s = (Beach)pos[i][f];
	                g2d.drawImage(s.getImage(), i*TILESIZE+camtopx, (f*TILESIZE)+camtopy, this);
				}
				else{
				}
				
			}
		}
		for (int i=0;i<pos.length;i++){
			for (int f=0;f<pos[i].length;f++){ 
				if (pos[i][f] instanceof Sea){
	                g.setColor(Color.blue);
	                g2d.fillRect((i*MINMAPSIZE)+MINMAPTOX, (f*MINMAPSIZE)+MINMAPTOY,MINMAPSIZE,MINMAPSIZE);
				}
				else if(pos[i][f] instanceof Land){
					g.setColor(Color.green);
		            g2d.fillRect((i*MINMAPSIZE)+MINMAPTOX, (f*MINMAPSIZE)+MINMAPTOY, MINMAPSIZE, MINMAPSIZE);
				}
				else if(pos[i][f] instanceof Beach){
					g.setColor(Color.yellow);
		            g2d.fillRect((i*MINMAPSIZE)+MINMAPTOX, (f*MINMAPSIZE)+MINMAPTOY, MINMAPSIZE, MINMAPSIZE);
				}
			}
		}
        g.setColor(Color.black);
		g.drawLine(((-camtopx*MINMAPSIZE)/TILESIZE)+MINMAPTOX, ((-camtopy*MINMAPSIZE)/TILESIZE)+MINMAPTOY, ((-camtopx*MINMAPSIZE)/TILESIZE)+MINMAPTOX+MINSCREENHEIGHT, ((-camtopy*MINMAPSIZE)/TILESIZE)+MINMAPTOY);
		g.drawLine(((-camtopx*MINMAPSIZE)/TILESIZE)+MINMAPTOX, ((-camtopy*MINMAPSIZE)/TILESIZE)+MINMAPTOY, ((-camtopx*MINMAPSIZE)/TILESIZE)+MINMAPTOX, ((-camtopy*MINMAPSIZE)/TILESIZE)+MINMAPTOY+MINSCREENWIDTH);
		g.drawLine(((-camtopx*MINMAPSIZE)/TILESIZE)+MINMAPTOX+MINSCREENHEIGHT, ((-camtopy*MINMAPSIZE)/TILESIZE)+MINMAPTOY, ((-camtopx*MINMAPSIZE)/TILESIZE)+MINMAPTOX+MINSCREENHEIGHT, ((-camtopy*MINMAPSIZE)/TILESIZE)+MINMAPTOY+MINSCREENWIDTH);
		g.drawLine(((-camtopx*MINMAPSIZE)/TILESIZE)+MINMAPTOX, ((-camtopy*MINMAPSIZE)/TILESIZE)+MINMAPTOY+MINSCREENWIDTH, ((-camtopx*MINMAPSIZE)/TILESIZE)+MINMAPTOX+MINSCREENHEIGHT, ((-camtopy*MINMAPSIZE)/TILESIZE)+MINMAPTOY+MINSCREENWIDTH);
	}
	public int randomh(int low,int high){
		int newrandom;
		double x;
		x = (Math.random()*(high-1))+low;
		newrandom = (int)x;
		return newrandom;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint(); 
		if (up)
			camtopy +=4;
		if (down)
			camtopy -=4;
		if (right)
			camtopx -=4;
		if (left)
			camtopx +=4;
	}
	public static void uppress(){
		up=true;
	}
	public static void downpress(){
		down=true;
	}
	public static void rightpress(){
		right=true;
	}
	public static void leftpress(){
		left=true;
	}
	public static void uprel() {
		up=false;
	}
	public static void downrel() {
		down=false;
	}
	public static void leftrel() {
		left=false;
	}
	public static void rightrel() {
		right=false;
	}
    private class TAdapter extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
        	keyhandler.keyReleaseds(e);
        }

        public void keyPressed(KeyEvent e) {
        	keyhandler.keyPresseds(e);
        
        }
    }
}
    

