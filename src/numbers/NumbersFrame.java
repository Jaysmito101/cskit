package numbers;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NumbersFrame extends JFrame {
    JTextPane textPane;

    public NumbersFrame(ArrayList<NumbersListItem> numbersListItems) {
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 1, 0, 0));
        textPane = new JTextPane();
        textPane.setText("Click any number button to start!");
        textPane.setFont(new Font("Arial", Font.PLAIN, 20));
        JScrollPane scrollPane = new JScrollPane(textPane);
        centerPanel.add(scrollPane);
        add(centerPanel, BorderLayout.CENTER);
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(numbersListItems.size() + 3, 1, 10, 10));
        JLabel header = new JLabel("Numbers");
        header.setFont(new Font("Arial", Font.BOLD, 35));
        eastPanel.add(header);
        for(NumbersListItem listItem: numbersListItems){
            JButton item = new JButton(listItem.name);
            item.addActionListener((e)->{
                textPane.setText(listItem.code);
            });
            eastPanel.add(item);
        }
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
