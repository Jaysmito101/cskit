package sorting.bogosort.gui;

import sorting.bogosort.utils.Constants;

import javax.swing.*;
import java.awt.*;

public class AnimPanel extends JPanel {

    public Bar[] list;

    public AnimPanel(){
        setSize(Constants.ANIMPANEL_WIDTH, Constants.ANIMPANEL_HEIGHT);
        randomize( 50);
    }

    public void randomize(int numberOfLines){
        int num = numberOfLines;
        list= new Bar[num];
        int width = (Constants.ANIMPANEL_WIDTH-2* Constants.PADDING)/num;
        for(int i=0;i<num;i++){
            Bar bar = Bar.createBar((int)(Math.random() * 100), width);
            list[i] = bar;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0;i<list.length;i++){
            list[i].renderImage();
            g.drawImage(list[i], Constants.PADDING   + i * list[i].getWidth(), getHeight() - list[i].getHeight() - Constants.PADDING, null);
        }
    }
}
