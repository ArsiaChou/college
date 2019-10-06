package beans;

public class AutoBean extends ExBean {
    public AutoBean(int number, String name, String value) {
        super(number, name, value);
    }

    public AutoBean() {
        super(3, "auto_name", "auto_value");
    }
}
