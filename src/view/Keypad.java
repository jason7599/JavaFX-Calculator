package src.view;

import src.view.button.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Keypad extends JPanel
{
    public Keypad()
    {
        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.add(new ClearButton());
        controlPanel.add(new BackButton());

        JPanel inputPanel = new JPanel(new GridLayout(1, 2));

        JPanel numpadPanel = new JPanel(new GridLayout(4, 3));
        for (int num = 1; num <= 9; num++)
            numpadPanel.add(new NumberButton(num));
        numpadPanel.add(new DecimalButton());
        numpadPanel.add(new NumberButton(0));
        numpadPanel.add(new JButton("="));

        JPanel opkeyPanel = new JPanel(new GridLayout(4, 1));
        opkeyPanel.add(new JButton("+"));
        opkeyPanel.add(new JButton("-"));
        opkeyPanel.add(new JButton("*"));
        opkeyPanel.add(new JButton("/"));

        inputPanel.add(numpadPanel);
        inputPanel.add(opkeyPanel);

        add(controlPanel);
        add(inputPanel);
    }
}
