package main.java.CreationalPatterns.FactoryMethod;

public class ContractorEmployeeInterface implements EmployeeInterface {

    String name;
    int age;
    String department;
    String type;

    public ContractorEmployeeInterface(String name, int age, String department, String type) {
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
        return "This is a part time employer:" + "\n{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

