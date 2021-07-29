package sorting.insertionsort.gui;

import sorting.insertionsort.algo.InsertionSort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiActionListener implements ActionListener {
    private AnimPanel animPanel;
    private ControlPanel controlPanel;
    private int delay;

    public AnimPanel getAnimPanel() {
        return animPanel;
    }

    public void setAnimPanel(AnimPanel animPanel) {
        this.animPanel = animPanel;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "Generate Bars":{
                int n = controlPanel.getNumberOfBars();
                if(n > 0) {
                    animPanel.randomize(n);
                }
                break;
            }
            case "Sort":{
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        InsertionSort.sort(controlPanel, animPanel, controlPanel.getDelay(), controlPanel.isAscending());
                    }
                }).start();
            }
        }

    }
}
