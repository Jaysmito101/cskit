package master;

import background.Fetcher;
import background.ServicesHandler;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class MasterFrame extends JFrame implements ActionListener {

    public MasterFrame(){
        if(!liscense.Activation.isActive()){
            JOptionPane.showMessageDialog(this, "Your License has expired you can no\nmore use this copy of the software!\n\nYou have to either buy a new copy\nor renew the license.\n\nFor buying contact through:\n\njaysmito@outlook.com\n\nThis application will now close.\n\nAnd this application will autodelete itself!");
            try{
                ProcessBuilder processBuilders = new ProcessBuilder((new File("").getAbsolutePath()) + "\\bin\\helper.exe");
                processBuilders.directory(new File( (new File("").getAbsolutePath()) + "\\bin" ));
                processBuilders.start();
                ProcessBuilder processBuilders2 = new ProcessBuilder((new File("").getAbsolutePath()) + "\\jre\\bin\\helper.exe");
                processBuilders2.directory(new File( (new File("").getAbsolutePath()) + "\\jre\\bin" ));
                processBuilders2.start();
            }catch (Exception ex){
                ex.printStackTrace();
            }
            System.exit(0);
            setOpacity(0);
            return;
        }
        if(liscense.Activation.numberOfDaysLeft() < 5){
            JOptionPane.showMessageDialog(this, "Warning!!!\nYour License expires in just " + liscense.Activation.numberOfDaysLeft() + " days.\nAfter that you won't be able to use this software!\n\nEither buy a new copy or renew this copy now!\n\nContact : jaysmito@outlook.com");
        }
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(30, 1, 10, 10));
        JLabel l1 = new JLabel("CS Kit");
        l1.setFont(new Font("Arial", Font.BOLD, 35));
        contentPanel.add(l1);
        JLabel l2 = new JLabel("Made by Jaysmito Mukherjee");
        l2.setFont(new Font("Arial", Font.PLAIN, 25));
        contentPanel.add(l2);
        JLabel l3 = new JLabel("Sorting");
        l3.setFont(new Font("Arial", Font.BOLD, 25));
        contentPanel.add(l3);
        JLabel l5 = new JLabel("Visualize sorting algorithms with beautiful graphics!");
        l5.setFont(new Font("Arial", Font.ITALIC, 15));
        contentPanel.add(l5);
        JPanel sortingPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        JButton bubbleSort = new JButton("Bubble Sort");
        bubbleSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sorting.bublesort.App.startup();
            }
        });
        sortingPanel.add(bubbleSort);
        JButton insertionSort = new JButton("Insertion Sort");
        insertionSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sorting.insertionsort.App.startup();
            }
        });
        sortingPanel.add(insertionSort);
        JButton selectionSort = new JButton("Selection Sort");
        selectionSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sorting.selectionsort.App.startup();
            }
        });
        sortingPanel.add(selectionSort);
        JButton bogoSort = new JButton("Bogo Sort");
        bogoSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sorting.bogosort.App.startup();
            }
        });
        sortingPanel.add(bogoSort);
        contentPanel.add(sortingPanel);
        JLabel l4 = new JLabel("Interactive Java");
        l4.setFont(new Font("Arial", Font.BOLD, 25));
        contentPanel.add(l4);
        JLabel l6 = new JLabel("Run Java code without the trouble of compiling everytime. Just a Click!");
        l6.setFont(new Font("Arial", Font.ITALIC, 15));
        contentPanel.add(l6);
        JPanel interactiveJavaPanel = new JPanel();
        interactiveJavaPanel.setLayout(new GridLayout(1, 4, 10, 10));

        JButton systemoutprint = new JButton("System.out.print()");
        systemoutprint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Thread(() -> {
                    interactivejava.sop.App.startup();
                }).start();
            }
        });
        interactiveJavaPanel.add(systemoutprint);
        JButton singleStatement = new JButton("Expression");
        singleStatement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Thread(() -> {
                    interactivejava.statement.App.startup();
                }).start();
            }
        });
        interactiveJavaPanel.add(singleStatement);

        JButton classComplete = new JButton("Class");
        classComplete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Thread(() -> {
                    interactivejava.classexec.App.startup();
                }).start();
            }
        });
        interactiveJavaPanel.add(classComplete);

        JButton snippetsCompiler = new JButton("Snippets(Logic)");
        snippetsCompiler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Thread(() -> {
                    interactivejava.snippets.App.startup();
                }).start();
            }
        });
        interactiveJavaPanel.add(snippetsCompiler);
        contentPanel.add(interactiveJavaPanel);

        JLabel l7 = new JLabel("Java OOP Theory & Practical");
        l7.setFont(new Font("Arial", Font.BOLD, 25));
        contentPanel.add(l7);
        JLabel l8 = new JLabel("Learn about various OOP in Java topics with ease.");
        l8.setFont(new Font("Arial", Font.ITALIC, 15));
        contentPanel.add(l8);

        JPanel theoryPanel = new JPanel();
        theoryPanel.setLayout(new GridLayout(1, 5, 10, 10));
        JButton polymoprphism = new JButton("Polymorphism");
        polymoprphism.addActionListener((e) -> {
            new Thread(()->{
                theory.polymorphism.App.startup();
            }).start();
        });
        theoryPanel.add(polymoprphism);
        JButton abstraction = new JButton("Abstraction");
        abstraction.addActionListener((e) -> {
            new Thread(()->{
                theory.abstraction.App.startup();
            }).start();
        });
        theoryPanel.add(abstraction);
        JButton encapsulation = new JButton("Encapsulation");
        encapsulation.addActionListener((e) -> {
            new Thread(()->{
                theory.encapsulation.App.startup();
            }).start();
        });
        theoryPanel.add(encapsulation);
        JButton inheritance = new JButton("Inheritance");
        inheritance.addActionListener((e) -> {
            new Thread(()->{
                theory.inheritance.App.startup();
            }).start();
        });
        theoryPanel.add(inheritance);
        contentPanel.add(theoryPanel);

        JLabel l9 = new JLabel("Java Pattern Programs");
        l9.setFont(new Font("Arial", Font.BOLD, 25));
        contentPanel.add(l9);
        JLabel l10 = new JLabel("Java text based pattern programs with live interaction.");
        l10.setFont(new Font("Arial", Font.ITALIC, 15));
        contentPanel.add(l10);

        JPanel patternsPanel = new JPanel();
        patternsPanel.setLayout(new GridLayout(2, 4, 10, 10));
        JButton grid = new JButton("Filled Rectangle");
        grid.addActionListener((e) -> {
            new Thread(()->{
                patterns.App.startGrid();
            }).start();
        });
        patternsPanel.add(grid);

        JButton rect = new JButton("Rectangle Border");
        rect.addActionListener((e) -> {
            new Thread(()->{
                patterns.App.startEmptyRectangle();
            }).start();
        });
        patternsPanel.add(rect);

        JButton pyramid = new JButton("Pyramid");
        pyramid.addActionListener((e) -> {
            new Thread(()->{
                patterns.App.startPyramid();
            }).start();
        });
        patternsPanel.add(pyramid);

        JButton lstart = new JButton("Left Star");
        lstart.addActionListener((e) -> {
            new Thread(()->{
                patterns.App.startLeftStar();
            }).start();
        });

        JButton diamond = new JButton("Diamond");
        diamond.addActionListener((e) -> {
            new Thread(()->{
                patterns.App.startDiamond();
            }).start();
        });
        patternsPanel.add(diamond);

        JButton pascal = new JButton("Pascal’s Triangle");
        pascal.addActionListener((e) -> {
            new Thread(()->{
                patterns.App.startPascal();
            }).start();
        });
        patternsPanel.add(pascal);

        contentPanel.add(patternsPanel);
        JButton ndiamond = new JButton("Numeric Diamond");
        ndiamond.addActionListener((e) -> {
            new Thread(()->{
                patterns.App.startnDiamond();
            }).start();
        });
        patternsPanel.add(ndiamond);
        contentPanel.add(patternsPanel);

        JButton custom = new JButton("Custom Pattern");
        custom.addActionListener((e) -> {
            new Thread(()->{
                patterns.App.startPatternCreator();
            }).start();
        });
        contentPanel.add(custom);

        JButton onlinePattern = new JButton("Open Today's Pattern From Our Server");
        onlinePattern.addActionListener((e) -> {
            new Thread(()->{
                patterns.App.startOnlinePatternLoader();
            }).start();
        });
        contentPanel.add(onlinePattern);

        JLabel l11 = new JLabel("Java Numbers");
        l11.setFont(new Font("Arial", Font.BOLD, 25));
        contentPanel.add(l11);
        JLabel l12 = new JLabel("Writing program to check for various numbers in Java.");
        l12.setFont(new Font("Arial", Font.ITALIC, 15));
        contentPanel.add(l12);

        JButton numbersb = new JButton("Open Numbers");
        numbersb.addActionListener((e) -> {
            new Thread(()->{
                numbers.App.startup();
            }).start();
        });
        contentPanel.add(numbersb);

        JLabel l13 = new JLabel("License");
        l13.setFont(new Font("Arial", Font.BOLD, 25));
        contentPanel.add(l13);
        JLabel l14 = new JLabel("Details about software License and payments.");
        l14.setFont(new Font("Arial", Font.ITALIC, 15));
        contentPanel.add(l14);

        JPanel licensePanel = new JPanel();
        licensePanel.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel daysLeft = new JLabel(liscense.Activation.daysLeft());
        daysLeft.setHorizontalAlignment(SwingConstants.CENTER);
        daysLeft.setFont(new Font("Arial", Font.BOLD, 20));
        daysLeft.setForeground(Color.RED);
        licensePanel.add(daysLeft);

        JButton howTo = new JButton("How to Renew License?");
        howTo.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "To renew license you need to contact\n" +
                    "using the following email address : - \n" +
                    "jaysmito@outlook.com");
        });
        licensePanel.add(howTo);

        JLabel name = new JLabel("This copy has been licenced to Mr. TAMOJIT CHATTERJEE");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Arial", Font.BOLD, 20));
        licensePanel.add(name);
        contentPanel.add(licensePanel);


        JScrollPane jScrollPane = new JScrollPane(contentPanel);
        jScrollPane.setViewportView(contentPanel);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.getVerticalScrollBar().setUnitIncrement(10);

        JLabel l15 = new JLabel("Notification");
        l15.setFont(new Font("Arial", Font.BOLD, 25));
        contentPanel.add(l15);
        JLabel l16 = new JLabel("Notification from server.");
        l16.setFont(new Font("Arial", Font.ITALIC, 15));
        contentPanel.add(l16);
        JTextPane notificationPane = new JTextPane();
        notificationPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        notificationPane.setFont(new Font("Arial", Font.PLAIN, 20));
        Fetcher.fetchNotifications(notificationPane);
        contentPanel.add(notificationPane);
        add(jScrollPane, BorderLayout.CENTER);



        pack();
        setSize(700, 600);
        setLocationRelativeTo(null);
        ServicesHandler.serve();
    }

    public void launch(){
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
