package src.controller;

import src.model.Operator;

public class Token
{
    public enum Type { INTEGER, DECIMAL, OPERATOR }

    private String str;
    private Type type;

    public String getStr() { return str; }
    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }

    public Token() // default zero token
    {
        this('0');
    }

    public Token(char digit)
    {
        if (digit == '.')
        {
            str = "0."; // default decimal token
            type = Type.DECIMAL;
        }
        else
        {
            str = Character.toString(digit);
            type = Type.INTEGER;
        }
    }

    public Token(Operator operator)
    {
        str = operator.toString();
        type = Type.OPERATOR;
    }

    public boolean isDefault()
    {
        return type == Type.INTEGER && str.equals("0");
    }

    public void push(char c)
    {
        str += c;
    }

    public char pop()
    {
        int len = str.length();
        char ret = str.charAt(len - 1);
        str = str.substring(0, len - 1);
        return ret;
    }

    public char lastChar()
    {
        return str.charAt(str.length() - 1);
    }

    public int length()
    {
        return str.length();
    }

}
