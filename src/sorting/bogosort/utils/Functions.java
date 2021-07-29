package sorting.bogosort.utils;

import java.awt.*;

public class Functions {
    private Functions(){}

    public static Color generateRandomColor(){
        return new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
    }

    public static String generateId(int length){
        String charset = "qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM1234567890";
        String res= "";
        for(int i=0;i<charset.length();i++){
            res += charset.charAt( (int)(Math.random() * charset.length()) );
        }
        return res;
    }
}
