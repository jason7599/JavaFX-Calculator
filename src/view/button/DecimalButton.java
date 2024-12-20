package src.view.button;

import src.controller.InputHandler;

public class DecimalButton extends Button
{
    public DecimalButton()
    {
        super(".");
    }

    @Override
    protected void invokeInputHandler()
    {
        InputHandler.appendDecimalPoint();
    }
}
