package main.java.CreationalPatterns.Builder;

public class Builder {
    private Lab2.Builder.Employee employee;

    public Builder(){
        this.employee = new Lab2.Builder.Employee();
    }

    public Builder setName(String name) {
        employee.setName(name);
        return this;
    }

    public Builder setAge(int age) {
        employee.setAge(age);
        return this;
    }

    public Builder setDepartment(String department) {
       employee.setDepartment(department);
       return this;
    }

    public Lab2.Builder.Employee build() {
        return this.employee;
    }
}
