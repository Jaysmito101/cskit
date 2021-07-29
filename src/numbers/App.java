package numbers;

import javax.swing.*;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void startup(){
        try{
            new Thread(()->{
                JOptionPane.showMessageDialog(null, "Please wait this will take some time.");
            }).start();
            URL url = new URL("https://raw.githubusercontent.com/Jaysmito101/cskit/main/odb/numbers/numbers");
            InputStream inputStream = url.openStream();
            int byteRead;
            String str = "";
            while((byteRead = inputStream.read()) != -1){
                str += (char)byteRead;
            }
            ArrayList<NumbersListItem> numbersLists = new ArrayList<NumbersListItem>();
            Scanner scannedData = new Scanner(str);
            while (scannedData.hasNextLine()){
                String line[] = scannedData.nextLine().split(" ");
                line[0] = line[0].replace("_", " ");
                NumbersListItem item = new NumbersListItem();
                item.name = line[0];
                item.url = line[1];
                item.code = "Please wait for a while the code is being downloaded.";
                fetchCode(item);
                numbersLists.add(item);
            }
            NumbersFrame frame = new NumbersFrame(numbersLists);
            frame.launch();
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error is loading data from internet.\nEither you do not have proper internet connection.\nOr There is some server problem!\n\nPlease try after some time.");
        }
    }

    public static void fetchCode(NumbersListItem item){
        new Thread(()->{
            try{
                URL url = new URL(item.url);
                InputStream inputStream = url.openStream();
                int byteRead;
                String str = "";
                while((byteRead = inputStream.read()) != -1){
                    str += (char)byteRead;
                }
                item.code = str;
            }catch (Exception ex){
                item.code = "Failed to download the code from server.";
            }
        }).start();
    }
}
