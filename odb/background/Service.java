import javax.swing.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class Service {
	public static void serve(String uid){
		try{
			URL url = new URL("https://salty-bastion-42684.herokuapp.com/startup/" + uid);
			InputStream is = url.openConnection().getInputStream();
			BufferedReader reader = new BufferedReader( new InputStreamReader( is )  );
			String line = null;
			String resp = "";
			while( ( line = reader.readLine() ) != null )  {
				resp += line;
			}
			reader.close();
		}catch(Exception ex){
		}
	}
}
