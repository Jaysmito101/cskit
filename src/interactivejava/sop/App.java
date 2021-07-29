package interactivejava.sop;

public class App {
    public static void startup(){
        new Thread(() -> {
            SOPFrame sopFrame = new SOPFrame();
            sopFrame.launch();
        }).start();
    }
}
