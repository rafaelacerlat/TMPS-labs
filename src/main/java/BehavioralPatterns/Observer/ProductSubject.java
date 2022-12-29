package BehavioralPatterns.Observer;

import BehavioralPatterns.Product;
import BehavioralPatterns.User;

import java.util.ArrayList;
import java.util.List;

public class ProductSubject  {
    List<User> observers = new ArrayList<>();
    String pid;

    public ProductSubject(String pid) {
        this.pid = pid;
    }

    public void addObserver(User user) {
        observers.add(user);
    }

    public void deleteObserver(User user) {
        observers.remove(user);
    }

    public void notifyObservers(Product product, double price) {
        observers.forEach(e -> e.notify(product, price));
    }
}
