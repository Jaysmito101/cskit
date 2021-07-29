package sorting.insertionsort;

import sorting.insertionsort.gui.InsertionSortFrame;

public class App {
    public static void startup() {
        try {
            new Thread(() -> {
                InsertionSortFrame frame = new InsertionSortFrame();
                frame.launch();
            }).start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
