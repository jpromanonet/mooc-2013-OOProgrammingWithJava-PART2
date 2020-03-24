package clicker.ui;

import clicker.applicationlogic.Calculator;
import clicker.applicationlogic.PersonalCalculator;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calculator;
    
    public UserInterface() {
        this(new PersonalCalculator());
    }
    
    public UserInterface(Calculator calculator) {
        this.calculator = calculator;
    }
    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Click Effect");
        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(2,1);
        container.setLayout(layout);
        ArrayList<JComponent> exerciseComponents = createExerciseComponents();
        addComponentsToContainer(exerciseComponents, container);
    }
    
    private ArrayList<JComponent> createExerciseComponents() {
        ArrayList<JComponent> components = new ArrayList<JComponent>();
        
        JLabel label = new JLabel(Integer.toString(this.calculator.giveValue()));
        JButton button = new JButton("Click!");
        ClickListener listener = new ClickListener(this.calculator, label);
        button.addActionListener(listener);
        
        components.add(label);
        components.add(button);
        return components;
    }
    
    private void addComponentsToContainer(ArrayList<JComponent> components, Container container) {
        for (JComponent component :
                components) {
            container.add(component);
        }
    }
    public JFrame getFrame() {
        return frame;
    }
}
