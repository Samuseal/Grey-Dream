package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    Image star;
    Timer timer;
    int x, y;
    int direction;

    public Board() 
    {
        setBackground(Color.BLACK);

        ImageIcon ii =
            new ImageIcon(this.getClass().getResource("Star.png"));
        star = ii.getImage();

        setDoubleBuffered(true);

        x = -30;
        y = 10;
        direction = 1;
        timer = new Timer(25, this);
        timer.start();
    }


    public void paint(Graphics g) 
    {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
    	if (direction==1)
    	{
  		      x += 1;
  		      y += 1;   		
    	}
    	else if(direction==2)
    	{
    		  x += 1;
    		  y -= 1;
    	}
    	else if(direction==3)
    	{
  		      x -= 1;
  		      y -= 1;    		
    	}
    	else if(direction==4)
    	{
  		      x -= 1;
  		      y += 1;    		
    	}


        if (y > 230 || y<-70 || x>200 || x<-100) 
        {
        	direction++;
            if (direction==5)
            {
            	direction=1;
            }
        	if (direction==1)
        	{
      		      x += 1;
      		      y += 1;   		
        	}
        	else if(direction==2)
        	{
        		  x += 1;
        		  y -= 1;
        	}
        	else if(direction==3)
        	{
      		      x -= 1;
      		      y -= 1;    		
        	}
        	else if(direction==4)
        	{
      		      x -= 1;
      		      y += 1;    		
        	}
        }
        repaint();
    }
}
