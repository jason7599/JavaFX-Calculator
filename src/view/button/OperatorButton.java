package src.view.button;

import src.model.Operator;
import src.controller.InputHandler;

public class OperatorButton extends CButton
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
