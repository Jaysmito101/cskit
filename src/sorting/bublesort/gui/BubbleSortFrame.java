package sorting.bublesort.gui;

import sorting.bublesort.utils.Constants;

import javax.swing.*;
import java.awt.*;

public class BubbleSortFrame extends JFrame {
    private AnimPanel animPanel;
    private ControlPanel controlPanel;


    public BubbleSortFrame(){
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
    }
}
