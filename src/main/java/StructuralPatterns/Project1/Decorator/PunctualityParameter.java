package StructuralPatterns.Project1.Decorator;

import StructuralPatterns.Project1.IEmployee;

public class PunctualityParameter implements EmployeeSalaryCalculatorDecorator{
    IEmployee employee;

    public PunctualityParameter(IEmployee Employee) {
        this.employee = Employee;
    }
    @Override
    public String getDescriptionOfQualityParameter() {
        return getClass().getSimpleName();
    }
    @Override
    public double calculateSalary() {
        return 1000 + employee.calculateSalary();
    }

    @Override
    public void showEmployeeDetails() {}

    @Override
    public void getSubordinates() {}
}
