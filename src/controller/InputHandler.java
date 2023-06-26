package src.controller;

import src.view.MainView;

import java.util.ArrayList;

public class InputHandler 
{
    private static ArrayList<Token> tokens = new ArrayList<>();

    private static Token lastToken()
    {
        return tokens.get(tokens.size() - 1);
    }
    
    public static void appendDigit(char number)
    {
        Token last = lastToken();

        if (last.getType() == Token.Type.OPERATOR) // TODO create new token
        {

        }
        else // extend token
        {
            if (last.isZero()) // overwrite zero
            {
                last.removeChar();
                MainView.display.removeChar();
            }

            last.appendChar(number);
            MainView.display.appendChar(number);
        }
    }

    public static void clear()
    {
        tokens.clear();
        tokens.add(new Token()); // default token
    }

    public static void back()
    {
        Token last = lastToken();

        last.removeChar(); // TODO if . removed change type
        MainView.display.removeChar();

        if (last.length() == 0) // token empty after removing
        {
            // if this token was the only token,
            // revert to default zero token
            if (tokens.size() == 1) 
            {
                last.appendChar('0');
                MainView.display.appendChar('0');
            }
            else
            {
                tokens.remove(tokens.size() - 1);
            }
        }
    }
}
