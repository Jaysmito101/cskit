package sorting.selectionsort.gui;

import sorting.selectionsort.utils.Constants;

import javax.swing.*;
import java.awt.*;

public class SelectionSortFrame extends JFrame {
    private AnimPanel animPanel;
    private ControlPanel controlPanel;


    public SelectionSortFrame(){
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        animPanel = new AnimPanel();
        add(animPanel, BorderLayout.CENTER);
        controlPanel = new ControlPanel(this, animPanel, new GuiActionListener());
        add(controlPanel, BorderLayout.EAST);
        setTitle("Selection Sort [by Jaysmto Mukherjee]");
        pack();
        setSize(getWidth() + 4 * Constants.PADDING + Constants.ANIMPANEL_WIDTH, Constants.CONTROLPANEL_HEIGHT);
        setLocationRelativeTo(null);
    }

    public void launch(){
        setVisible(true);
    }
}
