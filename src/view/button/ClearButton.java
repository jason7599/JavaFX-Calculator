package src.view.button;

import src.controller.InputHandler;

public class ClearButton extends CButton
{
    public ClearButton()
    {
        super("CLS");
    }

    @Override
    protected void invokeInputHandler() 
    {
        InputHandler.clear();
    }
}
