package theory.polymorphism;

import javax.swing.*;
import java.awt.*;

public class PolymorphismFrame extends JFrame {
    JTextPane textPane;

    public PolymorphismFrame() {
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 1, 0, 0));
        textPane = new JTextPane();
        textPane.setText("Click the Theory button to start!");
        textPane.setFont(new Font("Arial", Font.PLAIN, 20));
        JScrollPane scrollPane = new JScrollPane(textPane);
        centerPanel.add(scrollPane);
        add(centerPanel, BorderLayout.CENTER);
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(10, 1, 10, 10));
        JLabel header = new JLabel("Polymorphism");
        header.setFont(new Font("Arial", Font.BOLD, 35));
        eastPanel.add(header);
        JButton seeTheory = new JButton("Theory");
        seeTheory.addActionListener((e) -> {
            centerPanel.removeAll();
            centerPanel.add(scrollPane);
            textPane.setText("" +
                    "Polymorphism\n\n" +
                    "The four basic concepts of OOP (Object Oriented Programming) are Inheritance, Abstraction, Polymorphism and Encapsulation. For a video explanation of that go to : http://bit.ly/oopcrash.\n\n" +
                    "Polymorphism is the ability of an object or function to take on many forms. This functionality is helpful as it reduces the number of different function names and makes coding a lot easier.\n\n" +
                    "For example,\n" +
                    "We may require to calculate area of multiple shapes and in such a case rather than making different functions with different names we can have only one function name.\n\n" +
                    "So, the function signatures should be unique.\n" +
                    "area(int, int) // For rectangle.\n" +
                    "area(int) // For square.\n" +
                    "area(double) // For circle.\n" +
                    "The functions would be : \n" +
                    "public static int area(int l, int b) //For rectangle\n" +
                    "{\n" +
                    "    return (l * b);\n" +
                    "}\n" +
                    "\n" +
                    "public static int area(int s) //For square\n" +
                    "{\n" +
                    "    return (s * s);\n" +
                    "}\n" +
                    "\n" +
                    "public static int area(double r) //For circle\n" +
                    "{\n" +
                    "    return (int)(3.14 * r * r);\n" +
                    "}\n" +
                    "\n" +
                    "That easy!\n" +
                    "You can try them out either by writing the code in the Interactive Java window or by clicking the Live Example(area) button on the right side!" +
                    "");
            repaint();
        });
        eastPanel.add(seeTheory);
        JButton liveExample1 = new JButton("Live Example(area)");
        liveExample1.addActionListener((e) -> {
            try {
                centerPanel.removeAll();
                JPanel lx1 = new JPanel();
                lx1.setLayout(new GridLayout(10, 1, 10, 10));
                JLabel lt1 = new JLabel("Live Example(area)");
                lt1.setFont(new Font("Arial", Font.BOLD, 25));
                lx1.add(lt1);
                JLabel lt2 = new JLabel("For Rectangle : - ");
                lt2.setFont(new Font("Arial", Font.BOLD, 20));
                lx1.add(lt2);
                JPanel rectPanel = new JPanel();
                rectPanel.setLayout(new GridLayout(1, 6, 0, 0));
                JLabel lt3 = new JLabel("area(");
                lt3.setFont(new Font("Arial", Font.PLAIN, 20));
                rectPanel.add(lt3);
                JTextField inta = new JTextField();
                inta.setText("3");
                rectPanel.add(inta);
                JLabel lt4 = new JLabel(", ");
                lt4.setFont(new Font("Arial", Font.PLAIN, 20));
                rectPanel.add(lt4);
                JTextField intb = new JTextField();
                intb.setText("4");
                rectPanel.add(intb);
                JLabel lt5 = new JLabel(");");
                lt5.setFont(new Font("Arial", Font.PLAIN, 20));
                rectPanel.add(lt5);
                JButton call1 = new JButton("Call");
                call1.addActionListener((ee)->{
                    try {
                        int a = Integer.parseInt(inta.getText());
                        int b = Integer.parseInt(intb.getText());
                        JOptionPane.showMessageDialog(this, "Thr function returned value : " + (a*b));
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(this, "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
                rectPanel.add(call1);
                lx1.add(rectPanel);

                JLabel lt6 = new JLabel("For Square : - ");
                lt6.setFont(new Font("Arial", Font.BOLD, 20));
                lx1.add(lt6);
                JPanel rectPanel2 = new JPanel();
                rectPanel2.setLayout(new GridLayout(1, 6, 0, 0));
                JLabel lt7 = new JLabel("area(");
                lt7.setFont(new Font("Arial", Font.PLAIN, 20));
                rectPanel2.add(lt7);
                JTextField ints = new JTextField();
                ints.setText("3");
                rectPanel2.add(ints);
                JLabel lt8 = new JLabel(");");
                lt8.setFont(new Font("Arial", Font.PLAIN, 20));
                rectPanel2.add(lt8);
                JButton call2 = new JButton("Call");
                call2.addActionListener((ee)->{
                    try {
                        int s = Integer.parseInt(ints.getText());
                        JOptionPane.showMessageDialog(this, "Thr function returned value : " + (s*s));
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(this, "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
                rectPanel2.add(call2);
                lx1.add(rectPanel2);


                JLabel lt9 = new JLabel("For Circle : - ");
                lt9.setFont(new Font("Arial", Font.BOLD, 20));
                lx1.add(lt9);
                JPanel rectPanel3 = new JPanel();
                rectPanel3.setLayout(new GridLayout(1, 6, 0, 0));
                JLabel lt10 = new JLabel("area(");
                lt10.setFont(new Font("Arial", Font.PLAIN, 20));
                rectPanel3.add(lt10);
                JTextField doubler = new JTextField();
                doubler.setText("3.0");
                rectPanel3.add(doubler);
                JLabel lt11 = new JLabel(");");
                lt11.setFont(new Font("Arial", Font.PLAIN, 20));
                rectPanel3.add(lt11);
                JButton call3 = new JButton("Call");
                call3.addActionListener((ee)->{
                    try {
                        double r = Double.parseDouble(doubler.getText());
                        JOptionPane.showMessageDialog(this, "Thr function returned value : " + (Math.PI*r*r));
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(this, "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
                rectPanel3.add(call3);
                lx1.add(rectPanel3);

                centerPanel.add(lx1);
                setSize(getWidth() + 1, getHeight());
                setSize(getWidth() - 1, getHeight());
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
            }
        });
        eastPanel.add(liveExample1);

        JButton liveExample2 = new JButton("Live Example(add)");
        liveExample2.addActionListener((e) -> {
            try {
                centerPanel.removeAll();
                JPanel lx1 = new JPanel();
                lx1.setLayout(new GridLayout(10, 1, 10, 10));
                JLabel lt1 = new JLabel("Live Example(add)");
                lt1.setFont(new Font("Arial", Font.BOLD, 25));
                lx1.add(lt1);
                JLabel lt2 = new JLabel("For Integers : - ");
                lt2.setFont(new Font("Arial", Font.BOLD, 20));
                lx1.add(lt2);
                JPanel rectPanel = new JPanel();
                rectPanel.setLayout(new GridLayout(1, 6, 0, 0));
                JLabel lt3 = new JLabel("add(");
                lt3.setFont(new Font("Arial", Font.PLAIN, 20));
                rectPanel.add(lt3);
                JTextField inta = new JTextField();
                inta.setText("3");
                rectPanel.add(inta);
                JLabel lt4 = new JLabel(", ");
                lt4.setFont(new Font("Arial", Font.PLAIN, 20));
                rectPanel.add(lt4);
                JTextField intb = new JTextField();
                intb.setText("4");
                rectPanel.add(intb);
                JLabel lt5 = new JLabel(");");
                lt5.setFont(new Font("Arial", Font.PLAIN, 20));
                rectPanel.add(lt5);
                JButton call1 = new JButton("Call");
                call1.addActionListener((ee)->{
                    try {
                        int a = Integer.parseInt(inta.getText());
                        int b = Integer.parseInt(intb.getText());
                        JOptionPane.showMessageDialog(this, "Thr function returned value : " + (a + b));
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(this, "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
                rectPanel.add(call1);
                lx1.add(rectPanel);

                JLabel lt6 = new JLabel("For Double : - ");
                lt6.setFont(new Font("Arial", Font.BOLD, 20));
                lx1.add(lt6);
                JPanel rectPanel2 = new JPanel();
                rectPanel2.setLayout(new GridLayout(1, 6, 0, 0));
                JLabel lt7 = new JLabel("add(");
                lt7.setFont(new Font("Arial", Font.PLAIN, 20));
                rectPanel2.add(lt7);
                JTextField ints = new JTextField();
                ints.setText("3.0");
                rectPanel2.add(ints);
                JLabel lt13 = new JLabel(", ");
                lt13.setFont(new Font("Arial", Font.PLAIN, 20));
                rectPanel2.add(lt13);
                JTextField intsq = new JTextField();
                intsq.setText("4.0");
                rectPanel2.add(intsq);
                JLabel lt8 = new JLabel(");");
                lt8.setFont(new Font("Arial", Font.PLAIN, 20));
                rectPanel2.add(lt8);
                JButton call2 = new JButton("Call");
                call2.addActionListener((ee)->{
                    try {
                        double a = Double.parseDouble(ints.getText());
                        double b = Double.parseDouble(intsq.getText());
                        JOptionPane.showMessageDialog(this, "Thr function returned value : " + (a + b));
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(this, "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
                rectPanel2.add(call2);
                lx1.add(rectPanel2);


                JLabel lt9 = new JLabel("For String : - ");
                lt9.setFont(new Font("Arial", Font.BOLD, 20));
                lx1.add(lt9);
                JPanel rectPanel3 = new JPanel();
                rectPanel3.setLayout(new GridLayout(1, 6, 0, 0));
                JLabel lt10 = new JLabel("add(");
                lt10.setFont(new Font("Arial", Font.PLAIN, 20));
                rectPanel3.add(lt10);
                JTextField doubler = new JTextField();
                doubler.setText("Hello ");
                rectPanel3.add(doubler);
                JLabel lt14 = new JLabel(", ");
                lt14.setFont(new Font("Arial", Font.PLAIN, 20));
                rectPanel3.add(lt14);
                JTextField doubler2 = new JTextField();
                doubler2.setText("World!");
                rectPanel3.add(doubler2);
                JLabel lt11 = new JLabel(");");
                lt11.setFont(new Font("Arial", Font.PLAIN, 20));
                rectPanel3.add(lt11);
                JButton call3 = new JButton("Call");
                call3.addActionListener((ee)->{
                    try {
                        JOptionPane.showMessageDialog(this, "Thr function returned value : " + (doubler.getText() + doubler2.getText()));
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(this, "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
                rectPanel3.add(call3);
                lx1.add(rectPanel3);

                centerPanel.add(lx1);
                setSize(getWidth() + 1, getHeight());
                setSize(getWidth() - 1, getHeight());
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
            }
        });
        eastPanel.add(liveExample2);


        JButton close = new JButton("Close");
        close.addActionListener((e)->{
            dispose();
        });
        eastPanel.add(close);
        add(eastPanel, BorderLayout.EAST);
        setSize(900, 600);
        setLocationRelativeTo(null);
    }

    public void launch() {
        setVisible(true);
    }
}
