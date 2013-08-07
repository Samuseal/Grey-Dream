package main;
import java.awt.Image;

import javax.swing.ImageIcon;
public class MenuPause {
	private Image image;
	public MenuPause(){
        ImageIcon ii = new ImageIcon(this.getClass().getResource("../Pause.png"));
    	image = ii.getImage();

	}
    public Image getImage() {
        return image;
    }
}
