package src.view;

import java.awt.GridLayout;
import javax.swing.JFrame;

import src.controller.InputHandler;

public class MainView extends JFrame
{
    private static final String TITLE = "Calculator";
    private static final int WIDTH = 300;
    private static final int HEIGHT = 450;

    public static final Display display = new Display();

    private MainView()
    {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null); // center location
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new GridLayout(2, 1));

        add(display);
        add(new Keypad());

        setVisible(true);
        
        InputHandler.clear();
    }

    public static void main(String[] args)
    {
        new MainView();
    }
}
