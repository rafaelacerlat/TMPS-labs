package BehavioralPatterns;

import BehavioralPatterns.Command.*;
import org.junit.jupiter.api.Test;

public class CommandTest {
    @Test
    public void testCommand(){

        //Add an item to the New Releases category
        Product laptop = new Product("A001", "Notebook", 999);
        Category category = new Category("New Releases");
        ICommand command = new AddCommand(laptop, category);
        ProductManager productManager = new ProductManager();
        productManager.setCommand(command);
        productManager.process();

        //Delete an item from the New Releases category
        command = new DeleteCommand(laptop, category);
        productManager.setCommand(command);
        productManager.process();

    }
}
