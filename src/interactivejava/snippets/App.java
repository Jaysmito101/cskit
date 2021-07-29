package interactivejava.snippets;

public class App {
    public static void startup(){
        new Thread(() -> {
            SnipppetsFrame sopFrame = new SnipppetsFrame();
            sopFrame.launch();
        }).start();
    }
}
