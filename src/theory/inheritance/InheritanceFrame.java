package theory.inheritance;

import javax.swing.*;
import java.awt.*;

public class InheritanceFrame extends JFrame {
    JTextPane textPane;

    public InheritanceFrame() {
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
        JLabel header = new JLabel("Inheritance");
        header.setFont(new Font("Arial", Font.BOLD, 35));
        eastPanel.add(header);
        JButton seeTheory = new JButton("Theory");
        seeTheory.addActionListener((e) -> {
            centerPanel.removeAll();
            centerPanel.add(scrollPane);
            textPane.setText("" +
                    "Inheritance\n\n" +
                    "Inheritance is an important pillar of OOP(Object-Oriented Programming). It is the mechanism in java by which one class is allowed to inherit the features(fields and methods) of another class. \n" +
                    "\n" +
                    "Important terminology: \n" +
                    "\n" +
                    "Super Class: The class whose features are inherited is known as superclass(or a base class or a parent class).\n" +
                    "Sub Class: The class that inherits the other class is known as a subclass(or a derived class, extended class, or child class). The subclass can add its own fields and methods in addition to the superclass fields and methods.\n" +
                    "Reusability: Inheritance supports the concept of “reusability”, i.e. when we want to create a new class and there is already a class that includes some of the code that we want, we can derive our new class from the existing class. By doing this, we are reusing the fields and methods of the existing class.\n" +
                    "How to use inheritance in Java\n" +
                    "\n" +
                    "The keyword used for inheritance is extends. \n" +
                    "\n" +
                    "Syntax : \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "class derived-class extends base-class  \n" +
                    "{  \n" +
                    "   //methods and fields  \n" +
                    "}  \n" +
                    "Example: In the below example of inheritance, class Bicycle is a base class, class MountainBike is a derived class that extends Bicycle class and class Test is a driver class to run program. \n\n" +
                    "// Java program to illustrate the\n" +
                    "// concept of inheritance\n" +
                    " \n" +
                    "// base class\n" +
                    "class Bicycle {\n" +
                    "    // the Bicycle class has two fields\n" +
                    "    public int gear;\n" +
                    "    public int speed;\n" +
                    " \n" +
                    "    // the Bicycle class has one constructor\n" +
                    "    public Bicycle(int gear, int speed)\n" +
                    "    {\n" +
                    "        this.gear = gear;\n" +
                    "        this.speed = speed;\n" +
                    "    }\n" +
                    " \n" +
                    "    // the Bicycle class has three methods\n" +
                    "    public void applyBrake(int decrement)\n" +
                    "    {\n" +
                    "        speed -= decrement;\n" +
                    "    }\n" +
                    " \n" +
                    "    public void speedUp(int increment)\n" +
                    "    {\n" +
                    "        speed += increment;\n" +
                    "    }\n" +
                    " \n" +
                    "    // toString() method to print info of Bicycle\n" +
                    "    public String toString()\n" +
                    "    {\n" +
                    "        return (\"No of gears are \" + gear + \"\\n\"\n" +
                    "                + \"speed of bicycle is \" + speed);\n" +
                    "    }\n" +
                    "}\n" +
                    " \n" +
                    "// derived class\n" +
                    "class MountainBike extends Bicycle {\n" +
                    " \n" +
                    "    // the MountainBike subclass adds one more field\n" +
                    "    public int seatHeight;\n" +
                    " \n" +
                    "    // the MountainBike subclass has one constructor\n" +
                    "    public MountainBike(int gear, int speed,\n" +
                    "                        int startHeight)\n" +
                    "    {\n" +
                    "        // invoking base-class(Bicycle) constructor\n" +
                    "        super(gear, speed);\n" +
                    "        seatHeight = startHeight;\n" +
                    "    }\n" +
                    " \n" +
                    "    // the MountainBike subclass adds one more method\n" +
                    "    public void setHeight(int newValue)\n" +
                    "    {\n" +
                    "        seatHeight = newValue;\n" +
                    "    }\n" +
                    " \n" +
                    "    // overriding toString() method\n" +
                    "    // of Bicycle to print more info\n" +
                    "    @Override public String toString()\n" +
                    "    {\n" +
                    "        return (super.toString() + \"\\nseat height is \"\n" +
                    "                + seatHeight);\n" +
                    "    }\n" +
                    "}\n" +
                    " \n" +
                    "// driver class\n" +
                    "public class Test {\n" +
                    "    public static void main(String args[])\n" +
                    "    {\n" +
                    " \n" +
                    "        MountainBike mb = new MountainBike(3, 100, 25);\n" +
                    "        System.out.println(mb.toString());\n" +
                    "    }\n" +
                    "}\n" +
                    "Output\n" +
                    "No of gears are 3\n" +
                    "speed of bicycle is 100\n" +
                    "seat height is 25\n" +
                    "In the above program, when an object of MountainBike class is created, a copy of all methods and fields of the superclass acquire memory in this object. That is why by using the object of the subclass we can also access the members of a superclass. \n" +
                    "\n" +
                    "Please note that during inheritance only the object of the subclass is created, not the superclass. For more, refer Java Object Creation of Inherited Class.\n\n" +
                    "Types of Inheritance in Java\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Below are the different types of inheritance which are supported by Java. \n" +
                    "\n" +
                    "1. Single Inheritance: In single inheritance, subclasses inherit the features of one superclass. In the image below, class A serves as a base class for the derived class B.\n" +
                    "\n" +
                    "\n" +
                    "// Java program to illustrate the\n" +
                    "// concept of single inheritance\n" +
                    "import java.io.*;\n" +
                    "import java.lang.*;\n" +
                    "import java.util.*;\n" +
                    " \n" +
                    "class one {\n" +
                    "    public void print_geek()\n" +
                    "    {\n" +
                    "        System.out.println(\"Geeks\");\n" +
                    "    }\n" +
                    "}\n" +
                    " \n" +
                    "class two extends one {\n" +
                    "    public void print_for() { System.out.println(\"for\"); }\n" +
                    "}\n" +
                    "// Driver class\n" +
                    "public class Main {\n" +
                    "    public static void main(String[] args)\n" +
                    "    {\n" +
                    "        two g = new two();\n" +
                    "        g.print_geek();\n" +
                    "        g.print_for();\n" +
                    "        g.print_geek();\n" +
                    "    }\n" +
                    "}\n" +
                    "Output\n" +
                    "Geeks\n" +
                    "for\n" +
                    "Geeks\n" +
                    "Single_Inheritance\n" +
                    "\n" +
                    "2. Multilevel Inheritance: In Multilevel Inheritance, a derived class will be inheriting a base class and as well as the derived class also act as the base class to other class. In the below image, class A serves as a base class for the derived class B, which in turn serves as a base class for the derived class C. In Java, a class cannot directly access the grandparent’s members.\n" +
                    "\n" +
                    "\n" +
                    "// Java program to illustrate the\n" +
                    "// concept of Multilevel inheritance\n" +
                    "import java.io.*;\n" +
                    "import java.lang.*;\n" +
                    "import java.util.*;\n" +
                    " \n" +
                    "class one {\n" +
                    "    public void print_geek()\n" +
                    "    {\n" +
                    "        System.out.println(\"Geeks\");\n" +
                    "    }\n" +
                    "}\n" +
                    " \n" +
                    "class two extends one {\n" +
                    "    public void print_for() { System.out.println(\"for\"); }\n" +
                    "}\n" +
                    " \n" +
                    "class three extends two {\n" +
                    "    public void print_geek()\n" +
                    "    {\n" +
                    "        System.out.println(\"Geeks\");\n" +
                    "    }\n" +
                    "}\n" +
                    " \n" +
                    "// Drived class\n" +
                    "public class Main {\n" +
                    "    public static void main(String[] args)\n" +
                    "    {\n" +
                    "        three g = new three();\n" +
                    "        g.print_geek();\n" +
                    "        g.print_for();\n" +
                    "        g.print_geek();\n" +
                    "    }\n" +
                    "}\n" +
                    "Output\n" +
                    "Geeks\n" +
                    "for\n" +
                    "Geeks\n" +
                    "Multilevel_Inheritance\n" +
                    "\n" +
                    "3. Hierarchical Inheritance: In Hierarchical Inheritance, one class serves as a superclass (base class) for more than one subclass. In the below image, class A serves as a base class for the derived class B, C and D.\n" +
                    "\n" +
                    "\n" +
                    "// Java program to illustrate the\n" +
                    "// concept of Hierarchical  inheritance\n" +
                    " \n" +
                    "class A {\n" +
                    "    public void print_A() { System.out.println(\"Class A\"); }\n" +
                    "}\n" +
                    " \n" +
                    "class B extends A {\n" +
                    "    public void print_B() { System.out.println(\"Class B\"); }\n" +
                    "}\n" +
                    " \n" +
                    "class C extends A {\n" +
                    "    public void print_C() { System.out.println(\"Class C\"); }\n" +
                    "}\n" +
                    " \n" +
                    "class D extends A {\n" +
                    "    public void print_D() { System.out.println(\"Class D\"); }\n" +
                    "}\n" +
                    " \n" +
                    "// Driver Class\n" +
                    "public class Test {\n" +
                    "    public static void main(String[] args)\n" +
                    "    {\n" +
                    "        B obj_B = new B();\n" +
                    "        obj_B.print_A();\n" +
                    "        obj_B.print_B();\n" +
                    " \n" +
                    "        C obj_C = new C();\n" +
                    "        obj_C.print_A();\n" +
                    "        obj_C.print_C();\n" +
                    " \n" +
                    "        D obj_D = new D();\n" +
                    "        obj_D.print_A();\n" +
                    "        obj_D.print_D();\n" +
                    "    }\n" +
                    "}\n" +
                    "Output\n" +
                    "Class A\n" +
                    "Class B\n" +
                    "Class A\n" +
                    "Class C\n" +
                    "Class A\n" +
                    "Class D\n" +
                    "\n" +
                    "Hierarchical Inheritance\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "4. Multiple Inheritance (Through Interfaces): In Multiple inheritances, one class can have more than one superclass and inherit features from all parent classes. Please note that Java does not support multiple inheritances with classes. In java, we can achieve multiple inheritances only through Interfaces. In the image below, Class C is derived from interface A and B.\n" +
                    "\n" +
                    "\n" +
                    "// Java program to illustrate the\n" +
                    "// concept of Multiple inheritance\n" +
                    "import java.io.*;\n" +
                    "import java.lang.*;\n" +
                    "import java.util.*;\n" +
                    " \n" +
                    "interface one {\n" +
                    "    public void print_geek();\n" +
                    "}\n" +
                    " \n" +
                    "interface two {\n" +
                    "    public void print_for();\n" +
                    "}\n" +
                    " \n" +
                    "interface three extends one, two {\n" +
                    "    public void print_geek();\n" +
                    "}\n" +
                    "class child implements three {\n" +
                    "    @Override public void print_geek()\n" +
                    "    {\n" +
                    "        System.out.println(\"Geeks\");\n" +
                    "    }\n" +
                    " \n" +
                    "    public void print_for() { System.out.println(\"for\"); }\n" +
                    "}\n" +
                    " \n" +
                    "// Drived class\n" +
                    "public class Main {\n" +
                    "    public static void main(String[] args)\n" +
                    "    {\n" +
                    "        child c = new child();\n" +
                    "        c.print_geek();\n" +
                    "        c.print_for();\n" +
                    "        c.print_geek();\n" +
                    "    }\n" +
                    "}\n" +
                    "Output\n" +
                    "Geeks\n" +
                    "for\n" +
                    "Geeks\n" +
                    "Multiple_Inheritance\n" +
                    "\n" +
                    "5. Hybrid Inheritance(Through Interfaces): It is a mix of two or more of the above types of inheritance. Since java doesn’t support multiple inheritances with classes, hybrid inheritance is also not possible with classes. In java, we can achieve hybrid inheritance only through Interfaces.\n" +
                    " \n" +
                    "\n" +
                    "hybrid\n" +
                    "\n" +
                    "Important facts about inheritance in Java \n" +
                    "\n" +
                    "Default superclass: Except Object class, which has no superclass, every class has one and only one direct superclass (single inheritance). In the absence of any other explicit superclass, every class is implicitly a subclass of the Object class.\n" +
                    "Superclass can only be one: A superclass can have any number of subclasses. But a subclass can have only one superclass. This is because Java does not support multiple inheritances with classes. Although with interfaces, multiple inheritances are supported by java.\n" +
                    "Inheriting Constructors: A subclass inherits all the members (fields, methods, and nested classes) from its superclass. Constructors are not members, so they are not inherited by subclasses, but the constructor of the superclass can be invoked from the subclass.\n" +
                    "Private member inheritance: A subclass does not inherit the private members of its parent class. However, if the superclass has public or protected methods(like getters and setters) for accessing its private fields, these can also be used by the subclass.\n" +
                    "Java IS-A type of Relationship.\n" +
                    "\n" +
                    "IS-A is a way of saying: This object is a type of that object. Let us see how the extends keyword is used to achieve inheritance.\n" +
                    "\n" +
                    "public class SolarSystem {\n" +
                    "}\n" +
                    "public class Earth extends SolarSystem {\n" +
                    "}\n" +
                    "public class Mars extends SolarSystem {\n" +
                    "}\n" +
                    "public class Moon extends Earth {\n" +
                    "}\n" +
                    "Now, based on the above example, in Object-Oriented terms, the following are true:-\n" +
                    "\n" +
                    "SolarSystem the superclass of Earth class.\n" +
                    "SolarSystem the superclass of Mars class.\n" +
                    "Earth and Mars are subclasses of SolarSystem class.\n" +
                    "Moon is the subclass of both Earth and SolarSystem classes.\n" +
                    "\n" +
                    "class SolarSystem {\n" +
                    "}\n" +
                    "class Earth extends SolarSystem {\n" +
                    "}\n" +
                    "class Mars extends SolarSystem {\n" +
                    "}\n" +
                    "public class Moon extends Earth {\n" +
                    "    public static void main(String args[])\n" +
                    "    {\n" +
                    "        SolarSystem s = new SolarSystem();\n" +
                    "        Earth e = new Earth();\n" +
                    "        Mars m = new Mars();\n" +
                    " \n" +
                    "        System.out.println(s instanceof SolarSystem);\n" +
                    "        System.out.println(e instanceof Earth);\n" +
                    "        System.out.println(m instanceof SolarSystem);\n" +
                    "    }\n" +
                    "}\n" +
                    "Output\n" +
                    "true\n" +
                    "true\n" +
                    "true\n" +
                    "What all can be done in a Subclass?\n" +
                    "\n" +
                    "In sub-classes we can inherit members as is, replace them, hide them, or supplement them with new members: \n" +
                    "\n" +
                    "The inherited fields can be used directly, just like any other fields.\n" +
                    "We can declare new fields in the subclass that are not in the superclass.\n" +
                    "The inherited methods can be used directly as they are.\n" +
                    "We can write a new instance method in the subclass that has the same signature as the one in the superclass, thus overriding it (as in the example above, toString() method is overridden).\n" +
                    "We can write a new static method in the subclass that has the same signature as the one in the superclass, thus hiding it.\n" +
                    "We can declare new methods in the subclass that are not in the superclass.\n" +
                    "We can write a subclass constructor that invokes the constructor of the superclass, either implicitly or by using the keyword super.\n" +
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
