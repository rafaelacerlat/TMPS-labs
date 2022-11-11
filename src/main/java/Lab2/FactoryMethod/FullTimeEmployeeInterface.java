package main.java.Lab2.FactoryMethod;

public class FullTimeEmployeeInterface implements EmployeeInterface {
    String name;
    int age;
    String department;
    String type;

    public FullTimeEmployeeInterface(String name, int age, String department, String type) {
        this.name = name;
        this.age = age;
        this.department = department;
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
    public String getDepartment() {
        return department;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "This is a full time employer:" + "\n{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
