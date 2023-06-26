package src.view.button;

import src.controller.InputHandler;

public class BackButton extends Button
{
    public BackButton()
    {
        super("BACK");
    }

    @Override
    protected void invokeInputHandler()
    {
        InputHandler.back();
    }
}
