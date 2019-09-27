package cha02_pk01;

public class BeanT {
    private String name;
    private String value;

    public BeanT(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public BeanT() {
        name = "";
        value = "";
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

    @Override
    public String toString() {
        return "BeanT{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
