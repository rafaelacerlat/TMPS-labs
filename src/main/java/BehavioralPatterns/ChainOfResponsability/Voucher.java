package BehavioralPatterns.ChainOfResponsability;

public class Voucher {
    private final String name;
    private final double percentages;

    public Voucher(String name, double percentages) {
        this.name = name;
        this.percentages = percentages;
    }

    public String getName() {
        return name;
    }

    public double getPercentages() {
        return percentages;
    }
}
