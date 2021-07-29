package sorting.bublesort;

import sorting.bublesort.gui.BubbleSortFrame;

public class App {
    public static void startup() {
        try {
            new Thread(() -> {
                BubbleSortFrame frame = new BubbleSortFrame();
                frame.launch();
            }).start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
