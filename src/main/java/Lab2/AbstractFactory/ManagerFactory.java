package main.java.Lab2.AbstractFactory;

public class ManagerFactory implements MemberAbstractFactory {

    private String name;
    private int age;
    private String type;

    public ManagerFactory(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    @Override
    public Member createCompanyMember() {
        return new Lab2.AbstractFactory.Manager(name, age, type);
    }
}
