package main;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
public class Craft {
    private String craft = "Land.png";
    private int dx;
    private int dy;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Image image;
    public Craft() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        x = 40;
        y = 60;
    }
    public void move() {
        x += dx;
        y += dy;}
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Image getImage() {
        return image;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public boolean isVisible() {
        return visible;
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = 5;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = -5;
        }
        if (key == KeyEvent.VK_UP) {
            dy = 5;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = -5;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        if (key == KeyEvent.VK_ENTER) {
        }
    }
}