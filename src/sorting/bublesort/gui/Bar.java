package sorting.bublesort.gui;

import sorting.bublesort.utils.Constants;
import sorting.bublesort.utils.Functions;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bar extends BufferedImage {
    public int width;
    public double value;
    public Color color;


    public String ID;

    public static Bar createBar(double value, int w){
        value = value * 5;
        if(value == 0)
            value = 1;
        Bar bar = new Bar(w, (int)value, BufferedImage.TYPE_INT_RGB);
        bar.value = value;
        bar.width = w;
        bar.color = Functions.generateRandomColor();
        return bar;
    }

    private Bar(int width, int height, int imageType) {
        super(width, height, imageType);
        this.ID = Functions.generateId(128);
    }

    public void renderImage(){
        Graphics graphics = this.getGraphics();
        graphics.setColor(color);
        graphics.fillRect(0, 0, width, (int)value);
    }

    @Override
    public boolean equals(Object o) {
        return this.ID.equals(((Bar)o).ID);
    }

    public int compareTo(Object o){
        if(this.value == ((Bar)o).value){
            return 0;
        }else if(this.value > ((Bar)o).value){
            return 1;
        }else{
            return -1;
        }
    }
}
