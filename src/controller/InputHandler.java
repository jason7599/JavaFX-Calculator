package src.controller;

import src.view.MainView;

import java.util.ArrayList;

public class InputHandler 
{
    private InputHandler() {}

    private static ArrayList<Token> tokens = new ArrayList<>();

    public static void appendDigit(char digit)
    {
        Token last = tokens.get(tokens.size() - 1);

        if (last.getType() == Token.Type.OPERATOR)
        {
            tokens.add(new Token(digit));
        }
        else // extend token
        {
            if (last.isDefault()) // overwrite zero
            {
                last.pop();
                MainView.display.removeChar();
            }

            last.push(digit);
        }

        MainView.display.appendChar(digit);
    }

    public static void appendDecimalPoint()
    {
        Token last = tokens.get(tokens.size() - 1);
        if (last.getType() == Token.Type.INTEGER) 
        {
            last.push(Token.DECIMAL_POINT);
            last.setType(Token.Type.DECIMAL);
            MainView.display.appendChar(Token.DECIMAL_POINT);
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
        
                    MainView.display.removeChar(2);
                    MainView.display.appendChar(operator.chr);
                    MainView.display.appendBlank();
                }

                break;

            case DECIMAL: // if no decimal, convert back to int

                if (last.lastChar() == Token.DECIMAL_POINT)
                {
                    last.pop();
                    last.setType(Token.Type.INTEGER);
                    MainView.display.removeChar();
                }

                // no break 
            
            case INTEGER: // add new token
                tokens.add(new Token(operator));
                MainView.display.appendBlank(); // blank before operator
                MainView.display.appendChar(operator.chr);
                MainView.display.appendBlank(); // blank after operator
                break;
        }
    }

    public static void onCalculate()
    {
        int tokenCount = tokens.size();
        Token last = tokens.get(tokenCount - 1);
        if (last.getType() == Token.Type.OPERATOR) // remove unfinished operator
        {
            tokens.remove(tokenCount - 1);
            MainView.display.removeChar(3);
        }
    }

    public static void clear()
    {
        tokens.clear();
        tokens.add(new Token()); // default token
        MainView.display.setText(Token.DEFAULT_STR);
    }

    public static void back()
    {
        int tokenCount = tokens.size();
        Token last = tokens.get(tokenCount - 1);

        switch (last.getType())
        {
            case INTEGER:
                last.pop();
                MainView.display.removeChar();

                if (last.length() == 0) // token empty after removing
                {
                    if (tokenCount == 1) // if this token was the only token, revert to default zero token
                    {
                        last.push(Token.DEFAULT_CHR);
                        MainView.display.appendChar(Token.DEFAULT_CHR);
                    }
                    else
                    {
                        tokens.remove(tokenCount - 1); // remove this token
                    }
                }
                break;
            
            case DECIMAL:
                MainView.display.removeChar();
                if (last.pop() == Token.DECIMAL_POINT) // decimal point removed, convert back to int
                    last.setType(Token.Type.INTEGER);
                break;
            
            case OPERATOR:
                MainView.display.removeChar(3);
                tokens.remove(tokenCount - 1);
                break;
        }
    }
}
