package src.view;

import src.controller.Operator;
import src.view.button.*;

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
        numpadPanel.add(new CalculateButton());

        JPanel operatorPanel = new JPanel(new GridLayout(4, 1));
        for (Operator operator : Operator.values())
            operatorPanel.add(new OperatorButton(operator));

        inputPanel.add(numpadPanel);
        inputPanel.add(operatorPanel);

        add(controlPanel);
        add(inputPanel);
    }
}
