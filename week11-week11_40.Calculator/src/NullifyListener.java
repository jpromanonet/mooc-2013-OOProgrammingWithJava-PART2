import javax.swing.*;
import java.awt.event.ActionEvent;

public class NullifyListener extends CommonListener {
	
	public NullifyListener(JTextField input,JTextField output , JButton zbutton) {
		super(input, output, zbutton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CalculatorState.clear();
		output.setText("0");
		updateZButtonState();
		clearInputValue();
	}
}
