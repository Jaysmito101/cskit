package sorting.bogosort.gui;

import sorting.bogosort.utils.Constants;

import javax.swing.*;
import java.awt.*;

public class BogoSortFrame extends JFrame {
    private AnimPanel animPanel;
    private ControlPanel controlPanel;


    public BogoSortFrame(){
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        animPanel = new AnimPanel();
        add(animPanel, BorderLayout.CENTER);
        controlPanel = new ControlPanel(this, animPanel, new GuiActionListener());
        add(controlPanel, BorderLayout.EAST);
        setTitle("Bubble Sort [by Jaysmto Mukherjee]");
        pack();
        setSize(getWidth() + 4 * Constants.PADDING + Constants.ANIMPANEL_WIDTH, Constants.CONTROLPANEL_HEIGHT);
        setLocationRelativeTo(null);
    }

    public void launch(){
        setVisible(true);
        JOptionPane.showMessageDialog(this, "Hey this is the developer\n" +
                "Just an important message : -\n\n" +
                "This algorithm is very inefficient.\n" +
                "This may keep running for ever!\n" +
                "Please close the window to stop it!\n\n" +
                "Have a happy learning experience!");
    }
}
