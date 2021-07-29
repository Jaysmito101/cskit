package master;


import java.io.OutputStream;
import java.io.PrintStream;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting Up....");
        MasterFrame masterFrame =  new MasterFrame();
        masterFrame.setTitle("CS Kit - Jaysmito Mukherjee");
        masterFrame.launch();
    }
}

