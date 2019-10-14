package bean;

public class PriceStage {
    private int price;
    private int number;

    public PriceStage(int price, int number) {
        this.price = price;
        this.number = number;
    }

    public PriceStage() {
        this(0,0);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String toJson() {
        return "{" +
                "\"price\":"+price +
                ", \"number\":"+number +
                "}";
    }
}
