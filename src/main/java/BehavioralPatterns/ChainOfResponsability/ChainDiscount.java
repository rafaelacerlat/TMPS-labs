package BehavioralPatterns.ChainOfResponsability;

@FunctionalInterface
public interface ChainDiscount {
    boolean handleRequest();
}
