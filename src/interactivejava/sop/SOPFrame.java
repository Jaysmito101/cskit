package interactivejava.sop;

import master.MethodInvocationUtils;
import master.RuntimeCompiler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class SOPFrame extends JFrame {
    public JTextPane outputPane;
    public JTextField sopInput;

    public SOPFrame(){
        setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 3, 0, 0));
        JLabel l1 = new JLabel("System.out.println(");
        l1.setFont(new Font("Arial", Font.PLAIN, 20));
        inputPanel.add(l1);
        sopInput = new JTextField();
        sopInput.setText("\"Hello World!\"");
        sopInput.setFont(new Font("Arial", Font.PLAIN, 20));
        inputPanel.add(sopInput);
        JLabel l2 = new JLabel(");");
        l2.setFont(new Font("Arial", Font.PLAIN, 20));
        inputPanel.add(l2);
        centerPanel.add(inputPanel, BorderLayout.NORTH);
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
            if(sopInput.getText().contains("System.") || sopInput.getText().contains("RuntimeCompiler") || sopInput.getText().contains("throw new ") ) {
                JOptionPane.showMessageDialog(null, "The command you are trying to execute is not Allowed.");
                return;
            }
            RuntimeCompiler runtimeCompiler = new RuntimeCompiler();
            runtimeCompiler.addClass("Solution",
                    "import javax.swing.*;" +
                            "public class Solution{\n" +
                            "    public static Object execute(){\n" +
                            "        return (" + sopInput.getText() + ");\n" +
                            "    } \n" +
                            "public static String input(String message){\n" +
                            "    return JOptionPane.showInputDialog(null, message);\n" +
                            "}\n" +
                            "}");
            if(runtimeCompiler.compile()){
                String result = MethodInvocationUtils.invokeStaticMethod(runtimeCompiler.getCompiledClass("Solution"),"execute").toString();
                outputPane.setText(result);
            }else{
                JOptionPane.showMessageDialog(null, "Error in Execution!", "Error", JOptionPane.ERROR_MESSAGE);
                outputPane.setText(runtimeCompiler.debug);
            }
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
                "With this sowftware you can just execute\n" +
                "single line expressions, statements, snippets,\n" +
                "etc. Just with a single Click!\n\n" +
                "Get the output and errors in the same place easily.\n" +
                "" +
                "Just type a valid expression expression and go!\n\n" +
                "" +
                "However some things are not allowed like :-\n\n" +
                "You are not allowed to use the System class(though\n" +
                "you don\'t need it here.)\n" +
                "You are not allowed to write any malicious\n" +
                "piece of code!" +
                ""));
        eastPanel.add(showInformation);
        JButton examples = new JButton("Examples");
        examples.addActionListener(actionEvent -> outputPane.setText("" +
                "Examples : - \n\n" +
                "1) Hello World!" +
                "Just type \"Hello World!\" and click execute!\n\n" +
                "2) Use expressions:-\n" +
                "  (i)  4 + 2\n" +
                "  (ii) \"Hello\".compareTo(\"World!\")\n\n" +
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
