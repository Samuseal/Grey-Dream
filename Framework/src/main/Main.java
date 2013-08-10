package main;
import javax.swing.JFrame;

public class Main extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Main() {
        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setTitle("Game Framework");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
