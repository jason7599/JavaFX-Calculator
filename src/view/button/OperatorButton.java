package src.view.button;

import src.controller.InputHandler;
import src.controller.Operator;

public class OperatorButton extends Button
{
    private Operator operator;

    public OperatorButton(Operator operator)
    {
        super(operator.toString());
        this.operator = operator;
    }

    @Override
    protected void invokeInputHandler()
    {
        InputHandler.appendOperator(operator);
    }
}
