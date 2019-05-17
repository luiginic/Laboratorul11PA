package Laborator11.PA;

import javax.swing.*;
//import javax.swing.JButton;

public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;
    private JPanel mainFrame;

    private void createUIComponents()
    {
        controlPanel = new ControlPanel(this);
        designPanel = new DesignPanel(this);
    }

    public MainFrame() {
        super("Swing Designer");
        init();
    }
    private void init() {

        createUIComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.add(controlPanel);
        mainFrame.add(designPanel);
        this.add(mainFrame);
        //create and add to the frame the controlPanel and designPanel objects
        pack();
    }
    //create the main method
    public static void main(String[] args) {
        // write your code here
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}
