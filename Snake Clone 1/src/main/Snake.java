package main;
import javax.swing.JFrame;


public class Snake extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6027365757832237773L;

	public Snake() {

        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 340);
        setLocationRelativeTo(null);
        setTitle("Snake");

        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Snake();
    }
}
