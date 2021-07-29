package sorting.insertionsort.gui;

import sorting.insertionsort.utils.Constants;

import javax.swing.*;
import java.awt.*;

public class InsertionSortFrame extends JFrame {
    private AnimPanel animPanel;
    private ControlPanel controlPanel;


    public InsertionSortFrame(){
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        animPanel = new AnimPanel();
        add(animPanel, BorderLayout.CENTER);
        controlPanel = new ControlPanel(this, animPanel, new GuiActionListener());
        add(controlPanel, BorderLayout.EAST);
        setTitle("Insertion Sort [by Jaysmto Mukherjee]");
        pack();
        setSize(getWidth() + 4 * Constants.PADDING + Constants.ANIMPANEL_WIDTH, Constants.CONTROLPANEL_HEIGHT);
        setLocationRelativeTo(null);
    }

    public void launch(){
        setVisible(true);
    }
}
