package src.view;

import java.awt.GridLayout;
import javax.swing.JFrame;

import src.controller.InputHandler;
// import src.model.Operator;
// import src.model.Operator;

public class MainView extends JFrame
{
    private final String TITLE = "Calculator";
    private final int WIDTH = 300;
    private final int HEIGHT = 450;

    public static final Display display = new Display();

    private MainView()
    {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
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
        // for (int i = 0; i < 4; i++)
        // {
        //     System.out.println(Operator.Type.va);
        // }
        // System.out.println(Operator.Type.ADD.ordinal());

        new MainView();
    }
}
