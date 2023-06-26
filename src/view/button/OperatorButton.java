package src.view.button;

public class OperatorButton extends CButton
{
    public OperatorButton(char c)
    {
        super(Character.toString(c));
    }

    @Override
    protected void invokeInputHandler()
    {

    }
}
