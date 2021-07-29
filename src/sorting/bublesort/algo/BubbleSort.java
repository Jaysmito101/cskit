package sorting.bublesort.algo;

import sorting.bublesort.gui.AnimPanel;
import sorting.bublesort.gui.Bar;
import sorting.bublesort.gui.ControlPanel;

import java.awt.*;

public class BubbleSort {
    private BubbleSort(){}

    public static boolean sort(ControlPanel controlPanel, AnimPanel animPanel, int delay, boolean isAscending){
        try{
            if(delay < 0)
                return false;
            controlPanel.disableAllButtons();
            Bar[] arr = animPanel.list;
            if(isAscending){
                for(int i = 0 ; i < arr.length;i++){
                    for(int j = 0 ; j< arr.length-1-i;j++){
                        if(arr[j].value > arr[j + 1].value){
                            Color c1 = arr[j].color;
                            Color c2 = arr[j+ 1].color;
                            arr[j].color = Color.BLACK;
                            arr[j].width = arr[j].width + 10;
                            arr[j+1].color = Color.BLACK;
                            arr[j+1].width = arr[j+1].width + 10;
                            Bar tmp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = tmp;
                            animPanel.repaint();
                            Thread.sleep(delay);
                            arr[j].color = c2;
                            arr[j].width = arr[j].width - 10;
                            arr[j+1].color = c1;
                            arr[j+1].width = arr[j+1].width - 10;
                        }
                    }
                }
            }else{
                for(int i = 0 ; i < arr.length;i++){
                    for(int j = 0 ; j< arr.length-1-i;j++){
                        if(arr[j].value < arr[j + 1].value){
                            Color c1 = arr[j].color;
                            Color c2 = arr[j+ 1].color;
                            arr[j].color = Color.BLACK;
                            arr[j].width = arr[j].width + 10;
                            arr[j+1].color = Color.BLACK;
                            arr[j+1].width = arr[j+1].width + 10;
                            Bar tmp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = tmp;
                            animPanel.repaint();
                            Thread.sleep(delay);
                            arr[j].color = c2;
                            arr[j].width = arr[j].width - 10;
                            arr[j+1].color = c1;
                            arr[j+1].width = arr[j+1].width - 10;
                        }
                    }
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


}
