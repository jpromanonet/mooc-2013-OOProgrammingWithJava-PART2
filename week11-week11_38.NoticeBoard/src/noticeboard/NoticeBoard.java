package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class NoticeBoard implements Runnable {
	
	private JFrame frame;
	
	@Override
	public void run() {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		createComponents(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	
	private void createComponents(Container container) {
		GridLayout layout = new GridLayout(3, 1);
		container.setLayout(layout);
		ArrayList<JComponent> exerciseComponents = createExerciseComponents();
		addComponentsToContainer(exerciseComponents, container);
	}
	
	private ArrayList<JComponent> createExerciseComponents() {
		ArrayList<JComponent> compList = new ArrayList<JComponent>();
		JTextField textArea = new JTextField();
		JLabel label = new JLabel();
		
		JButton button = new JButton("Copy!");
		button.addActionListener(new ActionEventListener(textArea, label));
		
		compList.add(textArea);
		compList.add(button);
		compList.add(label);
		
		return compList;
	}
	
	private void addComponentsToContainer(ArrayList<JComponent> components, Container container) {
		for (JComponent component :
				components) {
			container.add(component);
		}
	}
}
