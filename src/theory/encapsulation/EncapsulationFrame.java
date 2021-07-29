package theory.encapsulation;

import javax.swing.*;
import java.awt.*;

public class EncapsulationFrame extends JFrame {
    JTextPane textPane;

    public EncapsulationFrame() {
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
        JLabel header = new JLabel("Encapsulation");
        header.setFont(new Font("Arial", Font.BOLD, 35));
        eastPanel.add(header);
        JButton seeTheory = new JButton("Theory");
        seeTheory.addActionListener((e) -> {
            centerPanel.removeAll();
            centerPanel.add(scrollPane);
            textPane.setText("" +
                    "Encapsulation\n\n" +
                    "Encapsulation is defined as the wrapping up of data under a single unit. It is the mechanism that binds together code and the data it manipulates. Another way to think about encapsulation is, it is a protective shield that prevents the data from being accessed by the code outside this shield. \n" +
                    " \n" +
                    "\n" +
                    "Technically in encapsulation, the variables or data of a class is hidden from any other class and can be accessed only through any member function of its own class in which it is declared.\n" +
                    "As in encapsulation, the data in a class is hidden from other classes using the data hiding concept which is achieved by making the members or methods of a class private, and the class is exposed to the end-user or the world without providing any details behind implementation using the abstraction concept, so it is also known as a combination of data-hiding and abstraction.\n" +
                    "Encapsulation can be achieved by Declaring all the variables in the class as private and writing public methods in the class to set and get the values of variables.\n" +
                    "\n" +
                    "\n" +
                    "// Java program to demonstrate encapsulation\n" +
                    "class Student {\n" +
                    "    // private variables declared\n" +
                    "    // these can only be accessed by\n" +
                    "    // public methods of class\n" +
                    "    private String name;\n" +
                    "    private int roll;\n" +
                    "    private int age;\n" +
                    "\n" +
                    "    // Constructor for creating objects\n" +
                    "    public Student(String sName, int sRoll, int sAge){\n" +
                    "        name = sName;\n" +
                    "        roll = sRoll;\n" +
                    "        age = sAge;\n" +
                    "    }\n" +
                    " \n" +
                    "    // get method for age to access\n" +
                    "    // private variable age\n" +
                    "    public int getAge() { return age; }\n" +
                    " \n" +
                    "    // get method for name to access\n" +
                    "    // private variable name\n" +
                    "    public String getName() { return name; }\n" +
                    " \n" +
                    "    // get method for roll to access\n" +
                    "    // private variable roll\n" +
                    "    public int getRoll() { return roll; }\n" +
                    " \n" +
                    "    // set method for age to access\n" +
                    "    // private variable age\n" +
                    "    public void setAge(int newAge) { age = newAge; }\n" +
                    " \n" +
                    "    // set method for name to access\n" +
                    "    // private variable geekName\n" +
                    "    public void setName(String newName)\n" +
                    "    {\n" +
                    "        name = newName;\n" +
                    "    }\n" +
                    " \n" +
                    "    // set method for roll to access\n" +
                    "    // private variable roll\n" +
                    "    public void setRoll(int newRoll) { roll = newRoll; }\n" +
                    "}\n" +
                    " \n" +
                    "public class Solution {\n" +
                    "    public static void main()\n" +
                    "    {\n" +
                    "        Student obj = new Student(\"Shyam\", 43, 16);\n" +
                    "\n" +
                    "        // Displaying values of the variables\n" +
                    "        System.out.println(\"Student name: \" + obj.getName());\n" +
                    "        System.out.println(\"Student age: \" + obj.getAge());\n" +
                    "        System.out.println(\"Student roll: \" + obj.getRoll());\n" +
                    " \n" +
                    "        // setting values of the variables\n" +
                    "        obj.setName(\"Jaysmito\");\n" +
                    "        obj.setAge(17);\n" +
                    "        obj.setRoll(19);\n" +
                    " \n" +
                    "        // Displaying values of the variables\n" +
                    "        System.out.println(\"Student name: \" + obj.getName());\n" +
                    "        System.out.println(\"Student age: \" + obj.getAge());\n" +
                    "        System.out.println(\"Student roll: \" + obj.getRoll());\n" +
                    " \n" +
                    "       // Direct access of roll is not possible\n" +
                    "       // due to encapsulation\n" +
                    "       // System.out.println(\"Student roll: \" + obj.roll); // This will cause an error\n" +
                    "       // as roll is a private data member.\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "\n" +
                    "Feel free to try out this code in the Interactive Java window!\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Advantages of Encapsulation:  \n" +
                    "\n" +
                    "Data Hiding:\n" +
                    "The user will have no idea about the inner implementation of the class. It will not be visible to the user how the class is storing values in the variables. The user will only know that we are passing the values to a setter method and variables are getting initialized with that value.\n" +
                    "\n" +
                    "Increased Flexibility:\n" +
                    "We can make the variables of the class as read-only or write-know that only depending on our requirement. If we wish to make the variables read-only then we have to omit the setter methods like setName(), setAge(), etc. from the above program or if we wish to make the variables as write-only then we have to omit the get methods like getName(), getAge(), etc. from the above program\n" +
                    "\n" +
                    "Reusability:\n" +
                    "Encapsulation also improves the re-usability and easy to change with new requirements.\n" +
                    "Testing code is easy: Encapsulated code is easy to test for unit testing.\n" +
                    "That easy!\n" +
                    "\n\n" +
                    "Live Examples Coming Soon ..." +
                    "");
            repaint();
        });
        eastPanel.add(seeTheory);

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
