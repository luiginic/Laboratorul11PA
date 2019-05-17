package Laborator11.PA;

import com.sun.xml.internal.txw2.output.XmlSerializer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private final JLabel classNameLabel = new JLabel("Class name");
    private final JTextField classNameField = new JTextField(30);
    private final JLabel textLabel = new JLabel("Default text");
    private final JTextField textField = new JTextField(10);
    private final JButton createButton = new JButton("Add component");
    private final JButton saveButton = new JButton("Save");
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {

        add(classNameLabel); add(classNameField); add(textLabel); add(textField); add(createButton); add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        createButton.addActionListener(e -> {
            JComponent comp = createDynamicComponent(classNameField.getText());

            frame.designPanel.addAtRandomLocation(comp);
            frame.designPanel.repaint();
            frame.repaint();
        });
        add(classNameLabel);
        add(classNameField);
        add(textLabel);
        add(textField);
        add(createButton);
    }
    public JComponent createDynamicComponent(String className) {
        JComponent comp;
        try {
            Class component = Class.forName(className);
            comp =(JComponent) component.newInstance();
            setComponentText(comp, textField.getText());
            return comp;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return new JTextArea("SOMETHING WENT WRONG");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new JTextArea("SOMETHING WENT WRONG");
        }
    }
    private void setComponentText(JComponent comp, String text) {
        Class[] signature = new Class[] {String.class};
        try {
            Method method = comp.getClass().getMethod("setText",signature);
            method.invoke(comp,text);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            if(comp instanceof JPanel){
                comp.setBorder(BorderFactory.createTitledBorder(text));
                comp.setPreferredSize(new Dimension(98,98));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


}
