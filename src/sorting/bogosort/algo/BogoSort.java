package sorting.bogosort.algo;

import sorting.bogosort.gui.AnimPanel;
import sorting.bogosort.gui.Bar;
import sorting.bogosort.gui.ControlPanel;

import javax.swing.*;
import java.awt.*;

public class BogoSort {
    private BogoSort(){}

    public static boolean sort(ControlPanel controlPanel, AnimPanel animPanel, int delay, boolean isAscending){
        try{
            if(delay < 0)
                return false;
            controlPanel.disableAllButtons();
            Bar[] arr = animPanel.list;
            if(isAscending){
                while(!isAscendingSorted(arr)){
                    shuffle(arr);
                    animPanel.repaint();
                    Thread.sleep(delay);
                }
            }else{
                while(!isDescendingSorted(arr)){
                    shuffle(arr);
                    animPanel.repaint();
                    Thread.sleep(delay);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        finally {
            controlPanel.enableAllButtons();
        }
        return true;
    }

    private static boolean isDescendingSorted(Bar[] arr) {
        for(int i=0;i< arr.length-1;i++){
            if(arr[i].value < arr[i+1].value)
                return false;
        }
        return true;
    }

    private static void shuffle(Bar[] arr) {
        for(int i=0;i< arr.length;i++){
            int t1 = (int)(Math.random() * arr.length);
            Bar a1 = arr[i];
            arr[i] = arr[t1];
            arr[t1] = a1;
        }
    }

    private static boolean isAscendingSorted(Bar[] arr) {
        for(int i=0;i< arr.length-1;i++){
            if(arr[i].value > arr[i+1].value)
                return false;
        }
        return true;
    }


}
