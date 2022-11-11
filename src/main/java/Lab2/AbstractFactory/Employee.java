package main.java.Lab2.AbstractFactory;

public class Employee extends Member {

    private String name;
    private int age;
    private String type;

    public Employee(String name, int age, String type) {
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
