package interactivejava.snippets;

import master.MethodInvocationUtils;
import master.RuntimeCompiler;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class SnipppetsFrame extends JFrame {
    public JTextPane outputPane, codeInput;

    public SnipppetsFrame(){
        setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 1, 10, 10));
        codeInput = new JTextPane();
        codeInput.setText("System.out.println(\"Hello World!\");");
        codeInput.setFont(new Font("Arial", Font.PLAIN, 20));
        JScrollPane scrollPaneInput = new JScrollPane(codeInput);
        centerPanel.add(scrollPaneInput);
        outputPane = new JTextPane();
        outputPane.setFont(new Font("Arial", Font.PLAIN, 20));
        outputPane.setText("Click on Information Button for details!");
        JScrollPane scrollPane = new JScrollPane(outputPane);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(4, 1, 10, 10));
        JButton execute = new JButton("Execute");
        execute.addActionListener(actionEvent -> new Thread(() -> {
            final String[] t = {""};
            PrintStream stdoutDefault = System.out;
            System.setOut(new PrintStream(new OutputStream() {
                @Override
                public void write(int b) {
                    t[0] += (char)b;
                }
            }));
            if(codeInput.getText().contains("System.set") || codeInput.getText().contains("System.in") || codeInput.getText().contains(".exit()") || codeInput.getText().contains("Runtime")) {
                JOptionPane.showMessageDialog(null, "The command you are trying to execute is not Allowed.");
                return;
            }
            RuntimeCompiler runtimeCompiler = new RuntimeCompiler();
            runtimeCompiler.addClass("Solution",
                    "import javax.swing.*;" +
                            "public class Solution{\n" +
                            "    public static Object execute(){\n" +
                            "       " + codeInput.getText() + "\n" +
                            "           " + (codeInput.getText().contains("return ")?"":"return null;") +"\n" +
                            "    } \n" +
                            "public static String input(String message){\n" +
                            "    return JOptionPane.showInputDialog(null, message);\n" +
                            "}\n" +
                            "}");
            if(runtimeCompiler.compile()){
                Object result = MethodInvocationUtils.invokeStaticMethod(runtimeCompiler.getCompiledClass("Solution"),"execute");
                if(result == null){
                    outputPane.setText("Output : -\n\n" +
                            t[0]
                            + "\n\nReturn value : null");
                }else{
                    outputPane.setText("Output : -\n\n" +
                            t[0]
                            + "\n\nReturn value : " + result.toString());
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error in Execution!", "Error", JOptionPane.ERROR_MESSAGE);
                outputPane.setText(runtimeCompiler.debug);
            }
            System.setOut(stdoutDefault);
        }).start());
        eastPanel.add(execute);
        JButton showInformation = new JButton("Information");
        showInformation.addActionListener(actionEvent -> outputPane.setText("" +
                "Interactive Java Execution\n\n\n" +
                "" +
                "This is a solution for students wanting to learn\n" +
                "Java and for teachers Teaching Java.\n\n" +
                "" +
                "This removes the long and boring parts of\n" +
                "programming like writing a whole class,\n" +
                "main method, etc. compiling it just for the\n" +
                "sake of running a simple statement.\n\n" +
                "With this software you can just execute\n" +
                "single line expressions, statements, snippets,\n" +
                "etc. Just with a single Click!\n\n" +
                "Get the output and errors in the same place easily.\n" +
                "" +
                "Just type valid statements and return any data type!\n\n" +
                "" +
                "However some things are not allowed like :-\n\n" +
                "You cannot create functions or classes in snippet mode!\n" +
                "You are not allowed to use the System class(though\n" +
                "you don\'t need it here.)\n" +
                "You are not allowed to write any malicious\n" +
                "piece of code!" +
                ""));
        eastPanel.add(showInformation);
        JButton examples = new JButton("Examples");
        examples.addActionListener(actionEvent -> outputPane.setText("" +
                "Examples : - \n\n" +
                "This works with anything you can think of!" +
                ""));
        eastPanel.add(examples);
        JButton close = new JButton("Close");
        close.addActionListener(actionEvent -> dispose());
        eastPanel.add(close);

        add(eastPanel, BorderLayout.EAST);
        setSize(700, 500);
        setLocationRelativeTo(null);
    }

    public void launch(){
        setVisible(true);
    }
}
