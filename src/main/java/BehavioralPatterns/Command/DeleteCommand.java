package BehavioralPatterns.Command;

import BehavioralPatterns.Product;

public class DeleteCommand implements ICommand {
    Product item;

    Category cat;

    public DeleteCommand(Product i, Category c) {
        item = i;
        cat = c;
    }

    public void execute() {
        cat.delete(item);
    }
}
