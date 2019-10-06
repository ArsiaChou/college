package beans;

public class ExBean {
    private int number;
    private String name;
    private String value;

    public ExBean(int number, String name, String value) {
        this.number = number;
        this.name = name;
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
        return "beans.ExBean{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
