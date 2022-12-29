package BehavioralPatterns.Command;

public class ProductManager {
    ICommand command;

    public void setCommand(ICommand c) {
        command = c;
    }

    public void process() {
        command.execute();
    }
}
