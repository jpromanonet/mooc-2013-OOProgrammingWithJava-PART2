import javax.swing.*;
import java.awt.event.ActionEvent;

public class AdditionListener extends CommonListener {
	
	public AdditionListener(JTextField input, JTextField output, JButton zbutton) {
		super(input, output, zbutton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		updateOutputValue();
		updateZButtonState();
		clearInputValue();
	}
	
	public void updateOutputValue() {
		if(inputIsInteger()) {
			CalculatorState.add(Integer.parseInt(input.getText()));
			this.output.setText(Integer.toString(CalculatorState.getCurrentValue()));
		} else {
			clearInputValue();
		}
	}
}
