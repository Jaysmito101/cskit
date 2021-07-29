package patterns.sdk;

public interface PatternLogic {
    public String generatePattern(int ...a);
    public String getCode();
    public void executeCode(String code);
    public String getName();
    public String getDetails();
    public void startStdoutCapture();
    public String stopStdoutCapture();
    public String generateDefaultPattern();
}
