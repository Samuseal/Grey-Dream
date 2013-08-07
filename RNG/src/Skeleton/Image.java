package Skeleton;

import javax.swing.JFrame;


public class Image extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5587933254793322399L;

	public Image() {

        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(280, 240);
        setLocationRelativeTo(null);
        setTitle("Desert");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Image();
    }
}