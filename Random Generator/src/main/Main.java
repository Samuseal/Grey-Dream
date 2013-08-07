package main;

import javax.swing.JFrame;

public class Main extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Main() {
        add(new Board());
        setTitle("Main");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500 , 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args) {
        new Main();
    }
}