package src.view.button;

import src.controller.InputHandler;

public class DecimalButton extends CButton
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
