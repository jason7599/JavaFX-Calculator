package src.controller;

public class Token
{
    public enum Type { INTEGER, DECIMAL, OPERATOR }

    private String str;
    private Type type;

    public String getStr() { return str; }
    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }

    public Token(int number)
    {
        str = String.valueOf(number);
        type = Type.INTEGER;
    }

    public Token() // default Token; "0"
    {
        this(0);
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

    public int length()
    {
        return str.length();
    }

}
