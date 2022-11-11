package Lab2.AbstractFactory;

import main.java.Lab2.AbstractFactory.Member;

public class Manager extends Member {
    private String name;
    private int age;
    private String type;

    public Manager(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getType() {
        return type;
    }
}
