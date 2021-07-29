package interactivejava.classexec;

public class App {
    public static void startup(){
        new Thread(() -> {
            ClassExecutorFrame sopFrame = new ClassExecutorFrame();
            sopFrame.launch();
        }).start();
    }
}
