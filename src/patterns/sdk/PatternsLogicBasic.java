package patterns.sdk;

import master.MethodInvocationUtils;
import master.RuntimeCompiler;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public abstract class PatternsLogicBasic implements PatternLogic {
    private String stdoutCapture = "";
    private PrintStream stdOut;

    @Override
    public void startStdoutCapture() {
        stdOut = System.out;
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                stdoutCapture += (char) b;
            }
        }));
    }

    @Override
    public void executeCode(String code) {
        try {
            if (code.contains("System.in") || code.contains("System.exit") || code.contains("Runtime")) {
                System.out.println("The code you are trying to execute is not allowed!");
                return;
            }

            RuntimeCompiler runtimeCompiler = new RuntimeCompiler();
            runtimeCompiler.addClass("Solution",
                    "import javax.swing.*;\n" +
                            "public class Solution{\n" +
                            "    public static void printPattern(){\n" +
                            "       " + code + "\n" +
                            "       return;\n" +
                            "    } \n" +
                            "\n" +
                            "public static String input(String message){\n" +
                            "    return (JOptionPane.showInputDialog(null, message, \"Input\", JOptionPane.OK_OPTION));" +
                            "}\n" +
                            "\n" +
                            "public static int integerInput(String message){\n" +
                            "    return Integer.parseInt(JOptionPane.showInputDialog(null, message, \"Input\", JOptionPane.OK_OPTION));" +
                            "}\n" +
                            "}");
            if (runtimeCompiler.compile()) {
                Class<?> solution = runtimeCompiler.getCompiledClass("Solution");
                MethodInvocationUtils.invokeStaticMethod(solution, "printPattern");
            } else {
                System.out.println(runtimeCompiler.debug);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in code execution.");
            System.out.println("Error in code execution.");
        }
    }

    @Override
    public String stopStdoutCapture() {
        System.setOut(stdOut);
        new Thread(()->{
            try {
                Thread.sleep(100);
                stdoutCapture = "";
            }catch (Exception ex){}
        }).start();
        return stdoutCapture;
    }
}
