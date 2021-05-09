public class Service{
  public void serve(String uid){
    try{
      Thread.sleep(1000);
      System.out.println(System.currentTimeMillis());
      serve(uid);
    }catch(Exception ex){}
  }
}
