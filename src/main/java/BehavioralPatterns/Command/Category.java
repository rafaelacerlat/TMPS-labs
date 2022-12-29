package BehavioralPatterns.Command;

import BehavioralPatterns.Product;
import java.util.*;

public class Category {
    private List<Product> items;

    private String categoryType;

    public Category(String s) {
        categoryType = s;
        items = new ArrayList<>();
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void add(Product i) {
        items.add(i);
        System.out.println("Item '" + i.getName() + "' has been added to the '"
                + getCategoryType() + "' Category ");
    }

    public void delete(Product i) {
        items.remove(i);
        System.out.println("Item '" + i.getName()
                + "' has been deleted from the '" + getCategoryType() + "' Category ");
    }
}
