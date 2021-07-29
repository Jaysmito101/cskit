package patterns;

import master.MethodInvocationUtils;
import master.RuntimeCompiler;
import patterns.sdk.PatternsFrame;
import patterns.sdk.PatternsLogicBasic;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class App {
    public static void startGrid() {
        PatternsFrame frame = new PatternsFrame(new PatternsLogicBasic() {
            @Override
            public String generatePattern(int... a) {
                String ret = "";
                for (int i = 0; i < a[0]; i++) {
                    for (int j = 0; j < a[1]; j++)
                        ret += "*";
                    ret += "\n";
                }
                return ret;
            }

            @Override
            public String getCode() {
                return "" +
                        "int l = integerInput(\"Enter length : \");\n" +
                        "int b = integerInput(\"Enter breadth : \");\n" +
                        "String ret = \"\";\n" +
                        "for(int i=0;i<l;i++) {\n" +
                        "    for (int j = 0; j <b; j++)\n" +
                        "        System.out.print(\"*\");\n" +
                        "    System.out.println();\n" +
                        "}\n" +
                        "";
            }

            @Override
            public String getName() {
                return "Filled Rectangle";
            }

            @Override
            public String getDetails() {
                return "Write program to print a rectangle of length l and breadth b.";
            }

            @Override
            public String generateDefaultPattern() {
                return generatePattern(3, 7);
            }
        });
        frame.launch();
    }

    public static void startEmptyRectangle() {
        PatternsFrame frame = new PatternsFrame(new PatternsLogicBasic() {
            @Override
            public String generatePattern(int... a) {
                String ret = "";
                for (int i = 0; i < a[0]; i++) {
                    for (int j = 0; j < a[1]; j++)
                        if (i == 0 || j == 0 || i == a[0] - 1 || j == a[1] - 1)
                            ret += "* ";
                        else
                            ret += "  ";
                    ret += "\n";
                }
                return ret;
            }

            @Override
            public String getCode() {
                return "" +
                        "int l = integerInput(\"Enter length : \");\n" +
                        "int b = integerInput(\"Enter breadth : \");\n" +
                        "String ret = \"\";\n" +
                        "for(int i=0;i<l;i++) {\n" +
                        "    for (int j = 0; j <b; j++)\n" +
                        "        if(i==0 || j == 0 || i == l - 1 || j == b - 1)\n" +
                        "            System.out.print(\"* \");\n" +
                        "        else\n" +
                        "            System.out.print(\"  \");" +
                        "    System.out.println();\n" +
                        "}\n" +
                        "";
            }

            @Override
            public String getName() {
                return "Empty Rectangle";
            }

            @Override
            public String getDetails() {
                return "Write program to print a rectangle border of length l and breadth b.";
            }

            @Override
            public String generateDefaultPattern() {
                return generatePattern(3, 7);
            }
        });
        frame.launch();
    }

    public static void startPyramid() {
        PatternsFrame frame = new PatternsFrame(new PatternsLogicBasic() {
            @Override
            public String generatePattern(int... a) {
                String ret = "";
                int n = a[0];
                for (int i = 0; i < n; i++) {
                    for (int j = n - i; j > 1; j--)
                        ret += (" ");
                    for (int j = 0; j <= i; j++)
                        ret += ("* ");
                    ret += "\n";
                }
                return ret;
            }

            @Override
            public String getCode() {
                return "" +
                        "int n = integerInput(\"Enter n :\");\n" +
                        "for (int i = 0; i < n; i++) {\n" +
                        "    for (int j = n - i; j > 1; j--)\n" +
                        "        System.out.print(\" \");\n" +
                        "    for (int j = 0; j <= i; j++)\n" +
                        "        System.out.print(\"* \");\n" +
                        "    System.out.println();\n" +
                        "}" +
                        "";
            }

            @Override
            public String getName() {
                return "Pyramid";
            }

            @Override
            public String getDetails() {
                return "Write program to print a Pyramid of n lines";
            }

            @Override
            public String generateDefaultPattern() {
                return generatePattern(7);
            }
        });
        frame.launch();
    }

    public static void startLeftStar() {
        PatternsFrame frame = new PatternsFrame(new PatternsLogicBasic() {
            @Override
            public String generatePattern(int... a) {
                String ret = "";
                int n = a[0];
                int i, j;
                for (i = 0; i < n; i++) {
                    for (j = 2 * (n - i); j >= 0; j--)
                        ret += (" ");
                    for (j = 0; j <= i; j++)
                        ret += ("* ");
                    ret += "\n";
                }
                return ret;
            }

            @Override
            public String getCode() {
                return "" +
                        "int n = integerInput(\"Enter n :\");\n" +
                        "int i, j;\n" +
                        "for (i = 0; i < n; i++) {\n" +
                        "    for (j = 2 * (n - i); j >= 0; j--)\n" +
                        "        System.out.print(\" \");\n" +
                        "    for (j = 0; j <= i; j++)\n" +
                        "        System.out.print(\"* \");\n" +
                        "    System.out.println();\n" +
                        "}" +
                        "";
            }

            @Override
            public String getName() {
                return "Left Star";
            }

            @Override
            public String getDetails() {
                return "Write program to print a Left Aligned Star of n lines";
            }

            @Override
            public String generateDefaultPattern() {
                return generatePattern(7);
            }
        });
        frame.launch();
    }

    public static void startDiamond() {
        PatternsFrame frame = new PatternsFrame(new PatternsLogicBasic() {
            @Override
            public String generatePattern(int... a) {
                String ret = "";
                int n, i, j, space = 1;
                n = a[0];
                space = n - 1;
                for (j = 1; j <= n; j++) {
                    for (i = 1; i <= space; i++)
                        ret += (" ");
                    space--;
                    for (i = 1; i <= 2 * j - 1; i++)
                        ret += ("*");
                    ret += "\n";
                }
                space = 1;
                for (j = 1; j <= n - 1; j++) {
                    for (i = 1; i <= space; i++)
                        ret += (" ");
                    space++;
                    for (i = 1; i <= 2 * (n - j) - 1; i++)
                        ret += ("*");
                    ret += "\n";
                }
                return ret;
            }

            @Override
            public String getCode() {
                return "" +
                        "int n, i, j, space = 1;\n" +
                        "n = integerInput(\"Enter n\");\n" +
                        "space = n - 1;\n" +
                        "for (j = 1; j <= n; j++) {\n" +
                        "    for (i = 1; i <= space; i++)\n" +
                        "        System.out.print(\" \");\n" +
                        "    space--;\n" +
                        "    for (i = 1; i <= 2 * j - 1; i++)\n" +
                        "        System.out.print(\"*\");\n" +
                        "    System.out.println(\"\");\n" +
                        "}\n" +
                        "space = 1;\n" +
                        "for (j = 1; j <= n - 1; j++) {\n" +
                        "    for (i = 1; i <= space; i++)\n" +
                        "        System.out.print(\" \");\n" +
                        "    space++;\n" +
                        "    for (i = 1; i <= 2 * (n - j) - 1; i++) \n" +
                        "        System.out.print(\"*\");\n" +
                        "    System.out.println(\"\");\n" +
                        "}" +
                        "";
            }

            @Override
            public String getName() {
                return "Diamond";
            }

            @Override
            public String getDetails() {
                return "Write program to print a Diamond of n lines";
            }

            @Override
            public String generateDefaultPattern() {
                return generatePattern(7);
            }
        });
        frame.launch();
    }

    public static void startnDiamond() {
        PatternsFrame frame = new PatternsFrame(new PatternsLogicBasic() {
            @Override
            public String generatePattern(int... a) {
                String ret = "";
                int n;
                n = a[0];
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j < i; j++)
                        ret += (" ");
                    for (int k = i; k <= n; k++)
                        ret += (k + " ");
                    ret += "\n";
                }
                for (int i = n - 1; i >= 1; i--) {
                    for (int j = 1; j < i; j++)
                        ret += (" ");
                    for (int k = i; k <= n; k++)
                        ret += (k + " ");
                    ret += ("\n");
                }
                return ret;
            }

            @Override
            public String getCode() {
                return "" +
                        "int n;\n" +
                        "n = integerInput(\"Enter n\");\n" +
                        "for (int i = 1; i <= n; i++) {\n" +
                        "    for (int j = 1; j < i; j++)\n" +
                        "        System.out.print(\" \");\n" +
                        "    for (int k = i; k <= n; k++)\n" +
                        "        System.out.print(k + \" \");\n" +
                        "    System.out.println();\n" +
                        "}\n" +
                        "for (int i = n - 1; i >= 1; i--) {\n" +
                        "    for (int j = 1; j < i; j++)\n" +
                        "        System.out.print(\" \");\n" +
                        "    for (int k = i; k <= n; k++)\n" +
                        "        System.out.print(k + \" \");\n" +
                        "    System.out.println();\n" +
                        "}" +
                        "";
            }

            @Override
            public String getName() {
                return "Numeric Diamond";
            }

            @Override
            public String getDetails() {
                return "Write program to print a Numeric Diamond of n lines";
            }

            @Override
            public String generateDefaultPattern() {
                return generatePattern(7);
            }
        });
        frame.launch();
    }

    public static void startPascal() {
        PatternsFrame frame = new PatternsFrame(new PatternsLogicBasic() {
            @Override
            public String generatePattern(int... a) {
                String ret = "";
                int n;
                n = a[0];
                int coe = 1, rows = n;
                for (int i = 0; i < rows; i++) {
                    for (int space = 1; space < rows - i; ++space)
                        ret += ("  ");
                    for (int j = 0; j <= i; j++) {
                        if (j == 0 || i == 0)
                            coe = 1;
                        else
                            coe = coe * (i - j + 1) / j;
                        ret += String.format("%4d", coe);
                    }
                    ret += "\n";
                }
                return ret;
            }

            @Override
            public String getCode() {
                return "" +
                        "int n;\n" +
                        "n = integerInput(\"Enter n\");\n" +
                        "int coe = 1, rows = n;\n" +
                        "for (int i = 0; i < rows; i++) {\n" +
                        "    for (int space = 1; space < rows - i; ++space)\n" +
                        "        System.out.print(\"  \");\n" +
                        "    for (int j = 0; j <= i; j++) {\n" +
                        "        if (j == 0 || i == 0)\n" +
                        "            coe = 1;\n" +
                        "        else\n" +
                        "            coe = coe * (i - j + 1) / j;\n" +
                        "        System.out.printf(\"%4d\", coe);\n" +
                        "    }\n" +
                        "    System.out.println();\n" +
                        "}" +
                        "";
            }

            @Override
            public String getName() {
                return "Pascal's Triangle";
            }

            @Override
            public String getDetails() {
                return "Write program to print n lines of the Pascal's Triangle";
            }

            @Override
            public String generateDefaultPattern() {
                return generatePattern(7);
            }
        });
        frame.launch();
    }

    public static void startPatternCreator() {
        PatternsFrame frame = new PatternsFrame(new PatternsLogicBasic() {
            @Override
            public String generatePattern(int... a) {
                return "Write your own code and run it!";
            }

            @Override
            public String getCode() {
                return "" +
                        "int n = integerInput(\"Enter n\");;\n\n" +
                        "// Write your here" +
                        "";
            }

            @Override
            public String getName() {
                return "Custom Pattern";
            }

            @Override
            public String getDetails() {
                return "Here are some ideas to try : -\n\n" +
                        "" +
                        "(1)\n\n" +
                        "* \n" +
                        "* * \n" +
                        "* * * \n" +
                        "* * * * \n" +
                        "* * * * * \n" +
                        "* * * * \n" +
                        "* * * \n" +
                        "* * \n" +
                        "*" +
                        "" +
                        "\n\n" +
                        "(2)\n\n" +
                        "1\n" +
                        "1 2\n" +
                        "1 2 3\n" +
                        "1 2 3 4\n" +
                        "1 2 3 4 5\n" +
                        "1 2 3 4 5 6\n" +
                        "1 2 3 4 5 6 7\n\n\n" +
                        "(3)\n\n" +
                        "1\n" +
                        "2 6\n" +
                        "3 7 10 \n" +
                        "4 8 11 13\n" +
                        "5 9 12 14 15";
            }

            @Override
            public String generateDefaultPattern() {
                return generatePattern(7);
            }
        });
        frame.launch();
    }

    public static void startOnlinePattern(PatternsLogicBasic patternsLogicBasic) {
        PatternsFrame patternsFrame = new PatternsFrame(patternsLogicBasic);
        patternsFrame.launch();
    }

    public static void startOnlinePatternLoader() {
        try {
            JOptionPane.showMessageDialog(null, "This feature will be available from the next Version!");
            if(1==1)
            return;
            new Thread(()->{
                JOptionPane.showMessageDialog(null, "Please wait this will take some time.");
            }).start();
            URL url = new URL("");
            InputStream inputStream = url.openStream();
            int byteRead;
            String str = "";
            while((byteRead = inputStream.read()) != -1){
                str += (char)byteRead;
            }
            RuntimeCompiler runtimeCompiler = new RuntimeCompiler();
            runtimeCompiler.addClass("OnlinePattern", str);
            if(runtimeCompiler.compile()){
                Class<?> onlinePatternClass = runtimeCompiler.getCompiledClass("OnlinePattern");
                PatternsLogicBasic patternsLogic = (PatternsLogicBasic)MethodInvocationUtils.invokeStaticMethod(onlinePatternClass, "getPatternLogic");
                if(patternsLogic == null){
                    throw new Exception("Runtime Faliure!");
                }else{
                    JOptionPane.showMessageDialog(null, "Successfully loaded online Pattern.");
                    App.startOnlinePattern(patternsLogic);
                }
            }else{
                System.out.println(runtimeCompiler.debug);
                throw new Exception("Compilation Failed!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error is loading pattern from internet.\nEither you do not have proper internet connection.\nOr There is some server problem!\n\nPlease try after some time.");
        }
    }
}

