package patterns.sdk;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PatternsFrame extends JFrame {
    public JTextPane codePane, outputPane;
    public String windowType;

    public PatternsFrame(PatternsLogicBasic codeLogic){
        this.windowType = codeLogic.getName();
        setLayout(new BorderLayout());
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        JPanel upperNorthPanel = new JPanel();

        upperNorthPanel.setLayout(new GridLayout(1, 5, 10, 10));
        JButton showOriginalCode = new JButton("Show Original Code");
        showOriginalCode.addActionListener((e)->{
            codePane.setText(codeLogic.getCode());
        });
        upperNorthPanel.add(showOriginalCode);
        JButton showDetails = new JButton("Show Question");
        showDetails.addActionListener((e)->{
            codePane.setText(codeLogic.getDetails());
        });
        upperNorthPanel.add(showDetails);
        JButton instructions = new JButton("Instructions");
        instructions.addActionListener((e)->{
            codePane.setText("Try to write a program to print the shown pattern!\n\nTo take input call the input(message) to take a string input or integerInput(message) to take int input as input through Scanner, BufferedReader through System.in has been disabled due to security reasons.\n\n You are not allowed to write a class or any function just the logic!\n\nRemove these line and write your code here!");
        });
        upperNorthPanel.add(instructions);
        JButton execute = new JButton("Execute Code");
        execute.addActionListener((e)->{
            codeLogic.startStdoutCapture();
            codeLogic.executeCode(codePane.getText());
            outputPane.setText(codeLogic.stopStdoutCapture());
        });
        upperNorthPanel.add(execute);
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener((e)-> {
                dispose();
        });
        upperNorthPanel.add(closeButton);

        northPanel.add(upperNorthPanel, BorderLayout.CENTER);

        JPanel lowerNorthPanel = new JPanel();
        JLabel l3 = new JLabel("Patterns [ "  + windowType +"]", SwingConstants.CENTER);
        l3.setFont(new Font("Arial", Font.BOLD, 25));
        lowerNorthPanel.add(l3, BorderLayout.NORTH);
        northPanel.add(lowerNorthPanel, BorderLayout.SOUTH);


        add(northPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2, 0, 0));
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        outputPane = new JTextPane();
        outputPane.setText(codeLogic.generateDefaultPattern());
        outputPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        outputPane.setFont(new Font("Arial", Font.PLAIN, 20));
        JScrollPane outputScrollPane = new JScrollPane(outputPane);
        JLabel l1 = new JLabel("Output Window");
        l1.setFont(new Font("Arial", Font.BOLD, 15));
        outputPanel.add(l1, BorderLayout.NORTH);
        outputPanel.add(outputScrollPane, BorderLayout.CENTER);
        centerPanel.add(outputPanel);
        codePane = new JTextPane();
        codePane.setText("Try to write a program to print the shown pattern!\n\nTo take input call the input() to take a string input or integerInput() to take int input as input through Scanner, BufferedReader through System.in has been disabled due to security reasons.\n\n You are not allowed to write a class or any function just the logic!\n\nRemove these line and write your code here!");
        codePane.setBorder(new EmptyBorder(20, 20, 20, 20));
        codePane.setFont(new Font("Arial", Font.PLAIN, 20));
        JScrollPane codePaneScroll = new JScrollPane(codePane);
        JPanel codePanel = new JPanel();
        codePanel.setLayout(new BorderLayout());
        JLabel l2 = new JLabel("Code Window");
        l2.setFont(new Font("Arial", Font.BOLD, 15));
        codePanel.add(l2, BorderLayout.NORTH);
        codePanel.add(codePaneScroll, BorderLayout.CENTER);
        centerPanel.add(codePanel);

        add(centerPanel, BorderLayout.CENTER);
        setTitle(windowType);
        setSize(1000, 600);
        setLocationRelativeTo(null);
    }

    public void launch(){
        setVisible(true);
    }
}
