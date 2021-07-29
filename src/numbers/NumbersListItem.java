package numbers;

public class NumbersListItem {
    public String name;
    public String code;
    public String url;

    @Override
    public String toString() {
        return "{\n" +
                "name : " + name + "\n" +
                "url : " + url + "\n" +
                "code : \n" + code + "\n" +
                "}";
    }
}
