package main;
import java.awt.Image;

import javax.swing.ImageIcon;
public class MenuMain {
	private Image image;
	public MenuMain(){
        ImageIcon ii = new ImageIcon(this.getClass().getResource("../Main.png"));
    	image = ii.getImage();

	}
    public Image getImage() {
        return image;
    }
}
