import javax.swing.*;
public class Service{
  public static void serve(String uid){
    try{
      System.out.println( "Service code : " +  (int)(Math.random()*10000) );
      Thread.sleep(1000);
    }catch(Exception ex){
      ex.printStackTrace();
    }
  }
}
