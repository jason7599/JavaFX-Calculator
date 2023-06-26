package src.model;

public enum Operator
{
    ADD('+'), SUBTRACT('-'), MULTIPLY('*'), DIVIDE('/');
    
    public final char chr;
    private Operator(char c) { chr = c; }

    @Override
    public String toString()
    {
        return Character.toString(chr);
    }
}

