import javax.swing.*;
import java.awt.event.ActionEvent;

public class SubtractionListener extends CommonListener {
	
	public SubtractionListener(JTextField input, JTextField output, JButton zbutton) {
		super(input, output, zbutton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		updateOutputValue();
		updateZButtonState();
		clearInputValue();
	}
	
	private void updateOutputValue() {
		if(inputIsInteger()) {
			CalculatorState.subtract(Integer.parseInt(input.getText()));
			output.setText(Integer.toString(CalculatorState.getCurrentValue()));
		} else {
			clearInputValue();
		}
	}
}
