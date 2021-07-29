package theory.abstraction;

import javax.swing.*;
import java.awt.*;

public class AbstractionFrame extends JFrame {
    JTextPane textPane;

    public AbstractionFrame() {
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
        JLabel header = new JLabel("Abstraction");
        header.setFont(new Font("Arial", Font.BOLD, 35));
        eastPanel.add(header);
        JButton seeTheory = new JButton("Theory");
        seeTheory.addActionListener((e) -> {
            centerPanel.removeAll();
            centerPanel.add(scrollPane);
            textPane.setText("" +
                    "Abstraction\n\n" +
                    "The four basic concepts of OOP (Object Oriented Programming) are Inheritance, Abstraction, Polymorphism and Encapsulation. For a video explanation of that go to : http://bit.ly/oopcrash.\n\n" +
                    "Data Abstraction is the property by virtue of which only the essential details are displayed to the user.The trivial or the non-essentials units are not displayed to the user. Ex: A car is viewed as a car rather than its individual components.\n" +
                    "\n" +
                    "Data Abstraction may also be defined as the process of identifying only the required characteristics of an object ignoring the irrelevant details. The properties and behaviors of an object differentiate it from other objects of similar type and also help in classifying/grouping the objects.\n" +
                    "\n" +
                    "Consider a real-life example of a man driving a car. The man only knows that pressing the accelerators will increase the speed of car or applying brakes will stop the car, but he does not know about how on pressing the accelerator the speed is actually increasing, he does not know about the inner mechanism of the car or the implementation of the accelerator, brakes etc in the car. This is what abstraction is. \n" +
                    "\n" +
                    "In java, abstraction is achieved by interfaces and abstract classes. We can achieve 100% abstraction using interfaces.\n" +
                    "\n" +
                    "Abstract classes and Abstract methods :  \n" +
                    "\n" +
                    "\n" +
                    "An abstract class is a class that is declared with abstract keyword.\n" +
                    "An abstract method is a method that is declared without an implementation.\n" +
                    "An abstract class may or may not have all abstract methods. Some of them can be concrete methods\n" +
                    "A method defined abstract must always be redefined in the subclass, thus making overriding compulsory OR either make subclass itself abstract.\n" +
                    "Any class that contains one or more abstract methods must also be declared with abstract keyword.\n" +
                    "There can be no object of an abstract class.That is, an abstract class can not be directly instantiated with the new operator.\n" +
                    "An abstract class can have parametrized constructors and default constructor is always present in an abstract class.\n" +
                    "When to use abstract classes and abstract methods with an example\n" +
                    "\n" +
                    "There are situations in which we will want to define a superclass that declares the structure of a given abstraction without providing a complete implementation of every method. That is, sometimes we will want to create a superclass that only defines a generalization form that will be shared by all of its subclasses, leaving it to each subclass to fill in the details.\n" +
                    "\n" +
                    "Consider a classic “shape” example, perhaps used in a computer-aided design system or game simulation. The base type is “shape” and each shape has a color, size and so on. From this, specific types of shapes are derived(inherited)-circle, square, triangle and so on — each of which may have additional characteristics and behaviors. For example, certain shapes can be flipped. Some behaviors may be different, such as when you want to calculate the area of a shape. The type hierarchy embodies both the similarities and differences between the shapes.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "// Java program to illustrate the\n" +
                    "// concept of Abstraction\n" +
                    "abstract class Shape {\n" +
                    "    String color;\n" +
                    " \n" +
                    "    // these are abstract methods\n" +
                    "    abstract double area();\n" +
                    "    public abstract String toString();\n" +
                    " \n" +
                    "    // abstract class can have constructor\n" +
                    "    public Shape(String color)\n" +
                    "    {\n" +
                    "        System.out.println(\"Shape constructor called\");\n" +
                    "        this.color = color;\n" +
                    "    }\n" +
                    " \n" +
                    "    // this is a concrete method\n" +
                    "    public String getColor() { return color; }\n" +
                    "}\n" +
                    "class Circle extends Shape {\n" +
                    "    double radius;\n" +
                    " \n" +
                    "    public Circle(String color, double radius)\n" +
                    "    {\n" +
                    " \n" +
                    "        // calling Shape constructor\n" +
                    "        super(color);\n" +
                    "        System.out.println(\"Circle constructor called\");\n" +
                    "        this.radius = radius;\n" +
                    "    }\n" +
                    " \n" +
                    "    @Override double area()\n" +
                    "    {\n" +
                    "        return Math.PI * Math.pow(radius, 2);\n" +
                    "    }\n" +
                    " \n" +
                    "    @Override public String toString()\n" +
                    "    {\n" +
                    "        return \"Circle color is \" + super.getColor()\n" +
                    "            + \"and area is : \" + area();\n" +
                    "    }\n" +
                    "}\n" +
                    "class Rectangle extends Shape {\n" +
                    " \n" +
                    "    double length;\n" +
                    "    double width;\n" +
                    " \n" +
                    "    public Rectangle(String color, double length,\n" +
                    "                     double width)\n" +
                    "    {\n" +
                    "        // calling Shape constructor\n" +
                    "        super(color);\n" +
                    "        System.out.println(\"Rectangle constructor called\");\n" +
                    "        this.length = length;\n" +
                    "        this.width = width;\n" +
                    "    }\n" +
                    " \n" +
                    "    @Override double area() { return length * width; }\n" +
                    " \n" +
                    "    @Override public String toString()\n" +
                    "    {\n" +
                    "        return \"Rectangle color is \" + super.getColor()\n" +
                    "            + \" and area is : \" + area();\n" +
                    "    }\n" +
                    "}\n" +
                    "public class Solution {\n" +
                    "    public static void main()\n" +
                    "    {\n" +
                    "        Shape s1 = new Circle(\"Red\", 2.2);\n" +
                    "        Shape s2 = new Rectangle(\"Yellow\", 2, 4);\n" +
                    "        System.out.println(s1.toString());\n" +
                    "        System.out.println(s2.toString());\n" +
                    "    }\n" +
                    "}\n" +
                    "Output:\n" +
                    "Shape constructor called\n" +
                    "Circle constructor called\n" +
                    "Shape constructor called\n" +
                    "Rectangle constructor called\n" +
                    "Circle color is Red and area is : 15.205308443374602\n" +
                    "Rectangle color is Yellow and area is : 8.0\n" +
                    "\n" +
                    "Feel free to try out this code in the Interactive Java window!" +
                    "\n" +
                    "Encapsulation vs Data Abstraction\n" +
                    "\n" +
                    "Encapsulation is data hiding(information hiding) while Abstraction is detail hiding(implementation hiding).\n" +
                    "While encapsulation groups together data and methods that act upon the data, data abstraction deals with exposing the interface to the user and hiding the details of implementation. \n" +
                    "Advantages of Abstraction\n" +
                    "\n" +
                    "It reduces the complexity of viewing the things.\n" +
                    "Avoids code duplication and increases reusability.\n" +
                    "Helps to increase security of an application or program as only important details are provided to the user.\n" +
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
