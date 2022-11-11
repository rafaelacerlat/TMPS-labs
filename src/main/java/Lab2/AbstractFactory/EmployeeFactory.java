package main.java.Lab2.AbstractFactory;


public class EmployeeFactory implements MemberAbstractFactory {
    private String name;
    private int age;
    private String type;

    public EmployeeFactory(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    @Override
    public Member createCompanyMember() {
        return new Employee(name, age, type);
    }
}
