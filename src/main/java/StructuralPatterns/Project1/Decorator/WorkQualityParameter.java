package StructuralPatterns.Project1.Decorator;

import StructuralPatterns.Project1.IEmployee;

public class WorkQualityParameter implements EmployeeSalaryCalculatorDecorator {
    IEmployee employee;

    public WorkQualityParameter(IEmployee employee) {
        this.employee = employee;
    }
    @Override
    public String getDescriptionOfQualityParameter() {
        return getClass().getSimpleName();
    }

    @Override
    public double calculateSalary() {
        return 1200 + employee.calculateSalary();
    }

    @Override
    public void showEmployeeDetails() {}

    @Override
    public void getSubordinates() {}
}
