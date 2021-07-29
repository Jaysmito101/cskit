package background;

import master.MethodInvocationUtils;
import master.RuntimeCompiler;

import javax.swing.*;
import java.io.InputStream;
import java.net.URL;

public class Fetcher {
    public static void fetchNotifications(JTextPane notificationPanel){
        new Thread(()->{
            try{
                notificationPanel.setText("Fetching notifications ...");
                URL url = new URL("https://raw.githubusercontent.com/Jaysmito101/cskit/main/odb/background/Notifications.java");
                InputStream inputStream = url.openStream();
                int byteRead;
                String str = "";
                while((byteRead = inputStream.read()) != -1){
                    str += (char)byteRead;
                }
                RuntimeCompiler compiler = new RuntimeCompiler();
                compiler.addClass("Notifications", str);
                if(compiler.compile()){
                    Class<?> notificationsClass = compiler.getCompiledClass("Notifications");
                    Object notification = MethodInvocationUtils.invokeStaticMethod(notificationsClass, "generateNotification", liscense.Activation.generateUID());
                    if(notification!=null){
                        notificationPanel.setText(notification.toString());
                    }else{
                        throw new Exception("Failed to fetch Notifications.");
                    }
                }else{
                    System.out.println(compiler.debug);
                    throw new Exception("Failed to fetch Notifications.");
                }
            }catch (Exception ex){
                ex.printStackTrace();
                notificationPanel.setText("Failed to download the notifications from server.");
            }
        }).start();
    }
}
