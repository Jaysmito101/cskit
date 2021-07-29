package sorting.bogosort;

import sorting.bogosort.gui.BogoSortFrame;

public class App {
    public static void startup() {
        try {
            new Thread(() -> {
                BogoSortFrame frame = new BogoSortFrame();
                frame.launch();
            }).start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
