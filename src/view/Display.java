package src.view;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Display extends JPanel
{
    private JTextArea textArea;

    public Display()
    {
        textArea = new JTextArea("0");
        textArea.setEditable(false);

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

    public void removeChar()
    {
        int t = textArea.getText().length();
        textArea.replaceRange(null, t - 1, t);
    }

    public void clear()
    {
        setText("0");
    }
}
