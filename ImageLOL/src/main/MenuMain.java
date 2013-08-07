package main;
import javax.swing.ImageIcon;
public class MenuMain {
	public static ImageIcon image = new ImageIcon(MenuMain.class.getResource("../Rescources/Images/Main.png"));
	public MenuMain(){}
	public ImageIcon getmenusplash(){
		return image;
	}
}
