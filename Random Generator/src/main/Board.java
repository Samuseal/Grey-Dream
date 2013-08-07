package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3102645872576761716L;
    private Image sea;
	public Board() {
		ImageIcon iid = new ImageIcon(this.getClass().getResource("sea.png"));
        sea = iid.getImage();
        setFocusable(true);
    }
    public void paint(Graphics g) {
        super.paint(g);
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
            for (int z = 0; z < 10; z++) {
            	g.drawImage(sea, z, z, null);
            }
    }

    public void actionPerformed(ActionEvent e) {


        repaint();
    }
}

