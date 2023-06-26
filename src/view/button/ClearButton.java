package src.view.button;

import src.controller.InputHandler;

public class ClearButton extends Button
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
