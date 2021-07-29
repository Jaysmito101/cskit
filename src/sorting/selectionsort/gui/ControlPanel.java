package sorting.selectionsort.gui;

import sorting.selectionsort.utils.Constants;

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

    public ControlPanel(Frame frame, AnimPanel animPanel, GuiActionListener guiActionListener){
        setListener(guiActionListener);
        listener.setControlPanel(this);
        listener.setAnimPanel(animPanel);
        this.animPanel = animPanel;
        setSize(Constants.CONTROLPANEL_WIDTH, Constants.CONTROLPANEL_HEIGHT);
        setLayout(new GridLayout(11, 1, 10, 10));
        JLabel header = new JLabel("   Selection Sort   ");
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
                        "Selection Sort\n\n" +
                        "In computer science, selection sort is an in-place comparison\n" +
                        "sorting algorithm. It has an O(n2) time complexity, which makes\n" +
                        "it inefficient on large lists, and generally performs worse than\n" +
                        "the similar insertion sort. Selection sort is noted for its simplicity\n" +
                        "and has performance advantages over more complicated algorithms\n" +
                        "in certain situations, particularly where auxiliary memory is limited.\n" +
                        "\n" +
                        "The algorithm divides the input list into two parts: a sorted\n" +
                        "sublist of items which is built up from left to right at the\n" +
                        "front (left) of the list and a sublist of the remaining unsorted\n" +
                        "items that occupy the rest of the list. Initially, the sorted\n" +
                        "sublist is empty and the unsorted sublist is the entire input list.\n" +
                        "The algorithm proceeds by finding the smallest (or largest, depending\n" +
                        "on sorting order) element in the unsorted sublist, exchanging (swapping)\n" +
                        "it with the leftmost unsorted element (putting it in sorted order),\n" +
                        "and moving the sublist boundaries one element to the right.\n" +
                        "\n" +
                        "The time efficiency of selection sort is quadratic, so there are a number\n" +
                        "of sorting techniques which have better time complexity than selection sort.\n" +
                        "One thing which distinguishes selection sort from other sorting algorithms\n" +
                        "is that it makes the minimum possible number of swaps, n − 1 in the worst case.\n" +
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
