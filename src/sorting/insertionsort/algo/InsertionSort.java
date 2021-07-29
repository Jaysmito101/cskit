package sorting.insertionsort.algo;

import sorting.insertionsort.gui.AnimPanel;
import sorting.insertionsort.gui.Bar;
import sorting.insertionsort.gui.ControlPanel;

import java.awt.*;
import java.util.ArrayList;

public class InsertionSort {
    private InsertionSort(){}

    public static boolean sort(ControlPanel controlPanel, AnimPanel animPanel, int delay, boolean isAscending){
        try{
            if(delay < 0)
                return false;
            controlPanel.disableAllButtons();
            Bar[] arr = animPanel.list;
            if(isAscending){
                Bar min;
                int minI;
                for(int i = 0 ; i < arr.length-1;i++){
                    minI = i;
                    min = arr[i];
                    for(int j =i ; j< arr.length;j++){
                        if(arr[j].value < min.value){
                            min = arr[j];
                            minI = j;
                        }
                    }
                    ArrayList<Color> arrayList = new ArrayList<Color>();
                    Color minColor = min.color;
                    min.color = Color.BLACK;
                    for(int j=i;j<minI;j++){
                        arrayList.add(arr[j].color);
                        arr[j].color = Color.DARK_GRAY;
                        arr[j].width = arr[j].width + 10;
                    }
                    for(int j=minI;j>i;j--){
                        arr[j] = arr[j - 1];
                    }
                    arr[i] = min;
                    animPanel.repaint();
                    Thread.sleep(delay);
                    min.color = minColor;
                    for(int j=i+1;j<minI+1;j++){
                        arr[j].color = arrayList.get(j - i - 1);
                        arr[j].width = arr[j].width - 10;
                    }
                }
            }else{
                Bar max;
                int maxI;
                for(int i = 0 ; i < arr.length-1;i++){
                    maxI = i;
                    max = arr[i];
                    for(int j =i ; j< arr.length;j++){
                        if(arr[j].value > max.value){
                            max = arr[j];
                            maxI = j;
                        }
                    }
                    ArrayList<Color> arrayList = new ArrayList<Color>();
                    Color maxColor = max.color;
                    max.color = Color.BLACK;
                    for(int j=i;j<maxI;j++){
                        arrayList.add(arr[j].color);
                        arr[j].color = Color.DARK_GRAY;
                        arr[j].width = arr[j].width + 10;
                    }
                    for(int j=maxI;j>i;j--){
                        arr[j] = arr[j - 1];
                    }
                    arr[i] = max;
                    animPanel.repaint();
                    Thread.sleep(delay);
                    max.color = maxColor;
                    for(int j=i+1;j<maxI+1;j++){
                        arr[j].color = arrayList.get(j - i - 1);
                        arr[j].width = arr[j].width - 10;
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
