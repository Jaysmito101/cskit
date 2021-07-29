package sorting.selectionsort.algo;

import sorting.selectionsort.gui.AnimPanel;
import sorting.selectionsort.gui.Bar;
import sorting.selectionsort.gui.ControlPanel;

import java.awt.*;

public class SelectionSort {
    private SelectionSort(){}

    public static boolean sort(ControlPanel controlPanel, AnimPanel animPanel, int delay, boolean isAscending){
        try{
            if(delay < 0)
                return false;
            controlPanel.disableAllButtons();
            Bar[] arr = animPanel.list;
            if(isAscending){
                double min;
                int minI;
                for(int i = 0 ; i < arr.length;i++){
                    minI = i;
                    min = arr[i].value;
                    for(int j =i ; j< arr.length;j++){
                        if(arr[j].value < min){
                            min = arr[j].value;
                            minI = j;
                        }
                    }
                    Color c1 = arr[i].color;
                    Color c2 = arr[minI].color;
                    arr[i].color = Color.BLACK;
                    arr[i].width = arr[i].width + 10;
                    arr[minI].color = Color.BLACK;
                    arr[minI].width = arr[minI].width + 10;
                    Bar tmp = arr[i];
                    arr[i] = arr[minI];
                    arr[minI] = tmp;
                    animPanel.repaint();
                    Thread.sleep(delay);
                    arr[i].color = c2;
                    arr[i].width = arr[minI].width - 10;
                    arr[minI].color = c1;
                    arr[minI].width = arr[minI].width - 10;
                }
            }else{
                double max;
                int maxI;
                for(int i = 0 ; i < arr.length;i++){
                    maxI = i;
                    max = arr[i].value;
                    for(int j =i ; j< arr.length;j++){
                        if(arr[j].value > max){
                            max = arr[j].value;
                            maxI = j;
                        }
                    }
                    Color c1 = arr[i].color;
                    Color c2 = arr[maxI].color;
                    arr[i].color = Color.BLACK;
                    arr[i].width = arr[i].width + 10;
                    arr[maxI].color = Color.BLACK;
                    arr[maxI].width = arr[maxI].width + 10;
                    Bar tmp = arr[i];
                    arr[i] = arr[maxI];
                    arr[maxI] = tmp;
                    animPanel.repaint();
                    Thread.sleep(delay);
                    arr[i].color = c2;
                    arr[i].width = arr[maxI].width - 10;
                    arr[maxI].color = c1;
                    arr[maxI].width = arr[maxI].width - 10;
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
