package sorting.bogosort.gui;

import sorting.bogosort.utils.Constants;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlPanel extends JPanel {
    private GuiActionListener listener;
    private AnimPanel animPanel;
    private JButton randomize, sort;
    private JTextField delay, numberOfBars;
    private JRadioButton asc, dec;


    public GuiActionListener getListener() {
        return listener;
    }

    public void setListener(GuiActionListener listener) {
        this.listener = listener;
    }

    public ControlPanel(BogoSortFrame frame, AnimPanel animPanel, GuiActionListener guiActionListener){
        setListener(guiActionListener);
        listener.setControlPanel(this);
        listener.setAnimPanel(animPanel);
        this.animPanel = animPanel;
        setSize(Constants.CONTROLPANEL_WIDTH, Constants.CONTROLPANEL_HEIGHT);
        setLayout(new GridLayout(11, 1, 10, 10));
        JLabel header = new JLabel("   Bogo Sort   ");
        header.setFont(new Font("Arial", Font.BOLD, 35));
        add(header);
        JLabel t3 = new JLabel("Number of Bars : ");
        t3.setFont(new Font("Arial", Font.BOLD, 20));
        add(t3);
        numberOfBars = new JTextField();
        numberOfBars.setText("50");
        ((AbstractDocument)numberOfBars.getDocument()).setDocumentFilter(new DocumentFilter(){
            Pattern regEx = Pattern.compile("\\d*");

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                Matcher matcher = regEx.matcher(text);
                if(!matcher.matches()){
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
        add(numberOfBars);
        randomize = new JButton("Generate Bars");
        randomize.addActionListener(listener);
        add(randomize);
        JLabel t1 = new JLabel("Choose Order :");
        t1.setFont(new Font("Arial", Font.BOLD, 20));
        add(t1);
        asc = new JRadioButton("Ascending Order");
        asc.setSelected(true);
        add(asc);
        dec = new JRadioButton("Descending Order");
        add(dec);
        ButtonGroup bg=new ButtonGroup();
        bg.add(asc);
        bg.add(dec);
        JLabel t2 = new JLabel("Delay(in milliseconds) : ");
        t2.setFont(new Font("Arial", Font.BOLD, 20));
        add(t2);
        delay = new JTextField();
        ((AbstractDocument)delay.getDocument()).setDocumentFilter(new DocumentFilter(){
            Pattern regEx = Pattern.compile("\\d*");

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                Matcher matcher = regEx.matcher(text);
                if(!matcher.matches()){
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
        delay.setText("500");
        add(delay);
        sort = new JButton("Sort");
        sort.addActionListener(listener);
        add(sort);
        JButton about = new JButton("About");
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "" +
                        "Bogo Sort" +
                        "\n\n" +
                        "BogoSort also known as permutation sort, stupid sort, slow sort,\n" +
                        "shotgun sort or monkey sort is a particularly ineffective algorithm\n" +
                        "based on generate and test paradigm. The algorithm successively\n" +
                        "generates permutations of its input until it finds one that is sorted.\n" +
                        "For example, if bogosort is used to sort a deck of cards, it would\n" +
                        "consist of checking if the deck were in order, and if it were not,\n" +
                        "one would throw the deck into the air, pick the cards up at random,\n" +
                        "and repeat the process until the deck is sorted.\n" +
                        "\n" +
                        "PseudoCode:\n" +
                        "\n" +
                        "while not Sorted(list) do\n" +
                        "    shuffle (list)\n" +
                        "done\n" +
                        "\n" +
                        "Example:\n" +
                        "\n" +
                        "Let us consider an example array ( 3 2 5 1 0 4 )\n" +
                        "4 5 0 3 2 1 (1st shuffling)\n" +
                        "4 1 3 2 5 0 (2ndshuffling)\n" +
                        "1 0 3 2 5 4 (3rd shuffling)\n" +
                        "3 1 0 2 4 5 (4th shuffling)\n" +
                        "1 4 5 0 3 2 (5th shuffling)\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        "0 1 2 3 4 5 (nth shuffling)—— Sorted Array\n" +
                        "\n" +
                        "Here, n is unknown because algorithm doesn’t known in which step the\n" +
                        "resultant permutation will come out to be sorted." +
                        "\n\nMade with Love By Jaysmito Mukherjee.");
            }
        });
        add(about);
    }

    public boolean isAscending(){
        return asc.isSelected();
    }

    public int getNumberOfBars(){
        try{
            int n =  Integer.parseInt(numberOfBars.getText());
            if(n<=0 || n > 500){
                throw  new Exception("Invalid Number of Bars. Must be greater than 0 and less than equal to 500");
            }
            return n;
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this, "Invalid Number Of Bars Value", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }

    public int getDelay(){
        try{
            int n =  Integer.parseInt(delay.getText());
            if(n<0){
                throw  new Exception("Invalid Delay");
            }
            return n;
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this, "Invalid Delay Value", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }

    public void disableAllButtons() {
        randomize.setEnabled(false);
        sort.setEnabled(false);
    }
    public void enableAllButtons() {
        randomize.setEnabled(true);
        sort.setEnabled(true);
    }

}
