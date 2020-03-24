
import java.awt.*;
import javax.swing.*;

public class GraphicCalculator implements Runnable {
	private JFrame frame;
	private JButton addition;
	private JButton subtraction;
	private JButton zbutton;
	private JTextField input;
	private JTextField output;
	private JPanel buttonPanel;
	
	@Override
	public void run() {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(400, 300));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Calculator");
		createComponents(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	
	private void createComponents(Container container) {
		GridLayout layout = new GridLayout(3, 1);
		container.setLayout(layout);
		
		initializeComponents();
		setComponentInitialState();
		addEventListenersToComponents();
		addButtonsToPanel();
		addComponentsToContainer(container);
	}
	
	private void setComponentInitialState() {
		output.setEnabled(false);
		zbutton.setEnabled(false);
	}
	private void initializeComponents() {
		addition = new JButton("+");
		subtraction = new JButton("-");
		zbutton = new JButton("Z");
		output = new JTextField("0");
		input = new JTextField("");
		buttonPanel = new JPanel(new GridLayout(1, 3));
	}
	
	private void addButtonsToPanel() {
		buttonPanel.add(addition);
		buttonPanel.add(subtraction);
		buttonPanel.add(zbutton);
	}
	
	private void addComponentsToContainer(Container container) {
		container.add(output);
		container.add(input);
		container.add(buttonPanel);
	}
	
	private void addEventListenersToComponents() {
		addition.addActionListener(new AdditionListener(input, output, zbutton));
		subtraction.addActionListener(new SubtractionListener(input, output, zbutton));
		zbutton.addActionListener(new NullifyListener(input, output, zbutton));
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
