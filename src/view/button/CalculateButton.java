package src.view.button;

import src.controller.InputHandler;

public class CalculateButton extends Button
{
    public CalculateButton()
    {
        super("=");
    }

    @Override
    protected void invokeInputHandler()
    {
        InputHandler.onCalculate();
    }
}
