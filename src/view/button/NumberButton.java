package src.view.button;

import src.controller.InputHandler;

public class NumberButton extends Button
{
    private char number;

    public NumberButton(int number)
    {
        super(String.valueOf(number));
        this.number = (char)(number + '0');
    }

    @Override
    protected void invokeInputHandler()
    {
        InputHandler.appendDigit(number);
    }
}
