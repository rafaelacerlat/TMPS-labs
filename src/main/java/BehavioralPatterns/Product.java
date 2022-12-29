package BehavioralPatterns;

public class Product {
    private String pid;
    private String name;
    private double price;

    public Product(String pid, String name, double price) {
        this.pid = pid;
        this.name = name;
        this.price = price;
    }

    public String getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
