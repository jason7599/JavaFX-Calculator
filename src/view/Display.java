package src.view;

import java.awt.Color;
import java.awt.ComponentOrientation;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Display extends JPanel
{
    private JTextArea textArea;

    public Display()
    {
        setBackground(Color.LIGHT_GRAY);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(textArea.getFont().deriveFont(30f));
        textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        add(textArea);
    }

    public void setText(String str)
    {
        textArea.setText(str);
    }

    public void appendChar(char c)
    {
        textArea.append(Character.toString(c));
    }

    public void appendBlank()
    {
        appendChar(' ');
    }

    public void removeChar()
    {
        removeChar(1);
    }

    public void removeChar(int len)
    {
        int t = textArea.getText().length();
        textArea.replaceRange(null, t - len, t);
    }
}
