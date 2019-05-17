package Laborator11.PA;

import javafx.scene.layout.Border;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DesignPanel extends JPanel {

    public static final int W = 800, H = 600;
    private final MainFrame frame;
    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        this.setBorder(BorderFactory.createTitledBorder("Design panel"));
        setPreferredSize(new Dimension(W, H));
        setLayout(null);
        //addAtRandomLocation(frame.controlPanel.createDynamicComponent("javax.swing.JButton"));
    }
    public void addAtRandomLocation(JComponent comp) {
        int x = new Random().nextInt(W-1); //create a random integer between 0 and W-1
        int y = new Random().nextInt(H-1);//create a random integer between 0 and H-1
        int w = comp.getPreferredSize().width;
        int h = comp.getPreferredSize().height;
        comp.setBounds(x, y, w, h);
        comp.setToolTipText(comp.getClass().getName());
        System.out.println("Component created of type: "+comp.getClass().getName()
                +"\n   Start point: "+x+"x "+y+"y"+"\n   Dimensions: "+w+"x"+h);

        this.add(comp);
//        comp.validate();
//        validate();
//        repaint();
//        frame.validate();
//        frame.repaint();
    }

}
