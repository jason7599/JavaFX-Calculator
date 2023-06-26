package src.controller;

import src.model.Operator;
import src.view.MainView;

import java.util.ArrayList;

public class InputHandler 
{
    private InputHandler() {}

    private static ArrayList<Token> tokens = new ArrayList<>();

    public static void appendDigit(char digit)
    {
        Token last = tokens.get(tokens.size() - 1);

        if (last.getType() == Token.Type.OPERATOR) // TODO create new token
        {

        }
        else // extend token
        {
            if (last.isDefault()) // overwrite zero
            {
                last.pop();
                MainView.display.removeChar();
            }

            last.push(digit);
            MainView.display.appendChar(digit);
        }
    }

    public static void appendDecimalPoint()
    {
        Token last = tokens.get(tokens.size() - 1);
        if (last.getType() == Token.Type.INTEGER) 
        {
            last.push('.');
            last.setType(Token.Type.DECIMAL);
            MainView.display.appendChar('.');
        }
    }

    public static void appendOperator(Operator operator)
    {
        Token last = tokens.get(tokens.size() - 1);

        switch (last.getType())
        {
            case OPERATOR: // replace operator

                if (!last.getStr().equals(operator.toString()))
                {
                    last.pop();
                    last.push(operator.chr);
        
                    MainView.display.removeChar();
                    MainView.display.appendChar(operator.chr);
                }

                break;

            case DECIMAL: // if no decimal, convert back to int

                if (last.lastChar() == '.')
                {
                    last.pop();
                    last.setType(Token.Type.INTEGER);
                    MainView.display.removeChar();
                }

                // no break 
            
            case INTEGER: // add new token
                tokens.add(new Token(operator));
                MainView.display.appendChar(operator.chr);
                break;
        }
    }

    public static void clear()
    {
        tokens.clear();
        tokens.add(new Token()); // default token
        MainView.display.clear();
    }

    public static void back()
    {
        int tokenCount = tokens.size();
        Token last = tokens.get(tokenCount - 1);

        if (last.pop() == '.') // decimal to int
        {
            last.setType(Token.Type.INTEGER);
        } 
        MainView.display.removeChar();

        if (last.length() == 0) // token empty after removing
        {
            if (tokenCount == 1) 
            {
                // if this token was the only token,
                // revert to default zero token
                last.push('0');
                MainView.display.appendChar('0');
            }
            else
            {
                tokens.remove(tokenCount - 1);
            }
        }
    }
}
