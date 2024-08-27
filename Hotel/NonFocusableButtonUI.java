package Hotel;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.*;

public class NonFocusableButtonUI extends BasicButtonUI 
{
	protected void installKeyboardActions(JButton button) 
	{
		super.installKeyboardActions(button);
		button.setFocusable(false);
	}
}