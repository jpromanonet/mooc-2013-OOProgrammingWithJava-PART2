import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract public class CommonListener implements ActionListener {
	protected JTextField input;
	protected JTextField output;
	protected JButton zbutton;
	
	public CommonListener(JTextField input, JTextField output, JButton zbutton) {
		this.input = input;
		this.output = output;
		this.zbutton = zbutton;
	}
	
	@Override
	abstract public void actionPerformed(ActionEvent e);
	
	protected void updateZButtonState() {
		disableIfZeroOutput();
	}
	
	protected void clearInputValue() {
		input.setText("");
	}
	
	protected void disableIfZeroOutput() {
		boolean outputIsNotZero = !output.getText().equals("0");
		zbutton.setEnabled(outputIsNotZero);
	}
	
	protected boolean inputIsInteger() {
		try {
			Integer.parseInt(input.getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
