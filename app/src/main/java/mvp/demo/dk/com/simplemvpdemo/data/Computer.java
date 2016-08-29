package mvp.demo.dk.com.simplemvpdemo.data;

/**
 * Created by DK-dong on 2016/8/23.
 */

public class Computer {
    private String name;
    private double price;
    private String model;

    public Computer(String name, double price, String model) {
        this.name = name;
        this.price = price;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Computer {" +
                "name='" + name + '\'' +
                ", price=" + price + '\'' +
                ", model=" + model +
                '}';
    }
}
