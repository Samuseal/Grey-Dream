package main;


import javax.swing.JFrame;

public class Pong extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Pong() {
        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 470);
        setLocationRelativeTo(null);
        setTitle("Tester");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Pong();
    }
}