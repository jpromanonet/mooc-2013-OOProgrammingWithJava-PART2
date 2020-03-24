package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        // Create your app here
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(200,300));
        frame.setTitle("Survey");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponent(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void createComponent(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        JLabel label1 = new JLabel("Are you?");
        container.add(label1);
        JCheckBox cb1 = new JCheckBox("Yes!");
        container.add(cb1);
        JCheckBox cb2 = new JCheckBox("No!");
        container.add(cb2);
        JLabel label2 = new JLabel("Why?");
        container.add(label2);
        
        JRadioButton choice1 = new JRadioButton("No reason.");
        JRadioButton choice2 = new JRadioButton("Because it is fun!");
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(choice1);
        bg.add(choice2);
        
        container.add(choice1);
        container.add(choice2);
        
        JButton btn = new JButton("Done!");
        container.add(btn);
    }

    public JFrame getFrame() {
        return frame;
    }
}
