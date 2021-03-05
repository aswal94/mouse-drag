import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

class MouseTracker extends JFrame implements MouseListener, MouseMotionListener {

    // static final serialVersionUID = 23098332;
    JLabel lblFromCoordinates;
    JLabel lblToCoordinates;

    int x1, y1;
    int x2, y2;

    JLabel lblCoordinates;
    boolean isPressed;

    public MouseTracker() {

        setLayout(new FlowLayout());

        addMouseListener(this);
        addMouseMotionListener(this);

        lblFromCoordinates = new JLabel("From: X, Y");
        lblToCoordinates = new JLabel("To: X, Y");
        lblCoordinates = new JLabel("Current: X, Y");

        add(lblFromCoordinates);
        add(lblToCoordinates);
        add(lblCoordinates);

        setTitle("Mouse Tracker");
        setBounds(200, 200, 800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mouseClicked(MouseEvent e) {
        // System.out.println("mouse clicked");
    }

    public void mouseEntered(MouseEvent e) {
        // System.out.println("Mouse entered");
    }

    public void mouseExited(MouseEvent e) {
        // System.out.println("Mouse Exited");
    }

    public void mousePressed(MouseEvent e) {
        // System.out.println("Mouse Pressed");
        isPressed = true;
        lblFromCoordinates.setText("From: " + e.getX() + ", " + e.getY());
        lblToCoordinates.setText("To: X, Y");

        x1 = e.getX();
        y1 = e.getY();

    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released");
        lblToCoordinates.setText("To: " + e.getX() + ", " + e.getY());
        isPressed = false;
    }

    public void mouseMoved(MouseEvent e) {
        // System.out.println("Mouse moved: " + e.getX() + ", " + e.getY());
        lblCoordinates.setText("Current: " + e.getX() + ", " + e.getY());

    }

    public void mouseDragged(MouseEvent e) {
        // System.out.println("Mouse dragged");
        lblToCoordinates.setText("To: " + e.getX() + ", " + e.getY());

        x2 = e.getX();
        y2 = e.getY();

        System.out.println("Diff");
        System.out.println("x: " + (x2 - x1));
        System.out.println("y: " + (y2 - y1));

        int delX = x2 - x1;
        int delY = y2 - y1;

        if (delX < 0) {
            System.out.println("left");
        } else if (delX > 0) {
            System.out.println("right");
        }

        if (delY > 0) {
            System.out.println("Down");
        } else if (delY < 0) {
            System.out.println("Up");
        }
        // if(delY < 0)

    }

    public static void main(String[] args) {
        MouseTracker mouseTracker = new MouseTracker();
        mouseTracker.show();
    }

}