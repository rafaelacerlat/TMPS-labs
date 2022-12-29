package BehavioralPatterns.Command;

import BehavioralPatterns.Product;

public class AddCommand implements ICommand {
    Product item;

    Category cat;

    public AddCommand(Product i, Category c) {
        item = i;
        cat = c;
    }

    public void execute() {
        cat.add(item);
    }
}
