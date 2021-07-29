package sorting.selectionsort;

import sorting.selectionsort.gui.SelectionSortFrame;

public class App {
    public static void startup() {
        try {
            new Thread(() -> {
                SelectionSortFrame frame = new SelectionSortFrame();
                frame.launch();
            }).start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
