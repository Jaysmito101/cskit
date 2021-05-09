public class OnlinePattern{
    public static PatternLogicBasic getPatternLogic(){
        return new PatternsLogicBasic() {
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
                        "ONLINE DEMO" +
                        "";
            }

            @Override
            public String getName() {
                return "Pattern Of the Day";
            }

            @Override
            public String getDetails() {
                return "Demo";
            }

            @Override
            public String generateDefaultPattern() {
                return generatePattern(7);
            }
        };
    }
}
