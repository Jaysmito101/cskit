package background;

public class ServiceStorage {
    public String name;

    @Override
    public String toString() {
        return "ServiceStorage{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public String url;
    public String code;
}
