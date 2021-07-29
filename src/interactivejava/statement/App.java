package interactivejava.statement;

public class App {
    public static void startup(){
        new Thread(() -> {
            StatementFrame sopFrame = new StatementFrame();
            sopFrame.launch();
        }).start();
    }
}
