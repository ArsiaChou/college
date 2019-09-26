package bean;

public class BeanT {
    private String name;
    private String value;

    public BeanT() {
        name = "";
        value = "";
    }
    public String toString() {
        return "Bean T";
    }

    public BeanT createNotStatic() {
        return new BeanT();
    }

    public static BeanT createStatic() {
        return new BeanT();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
