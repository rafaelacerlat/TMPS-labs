package StructuralPatterns.Project1.Composite;

import StructuralPatterns.Project1.IEmployee;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Developer implements IEmployee {
    private long id;
    private String name;


    @Override
    public void showEmployeeDetails() {
        System.out.println(name + " (id=" + id + ") is working as a developer");
    }

    @Override
    public void getSubordinates()
    {
        System.out.println(name + " is a developer, without any subordinates");
    }

    @Override
    public double calculateSalary() {
        return 15000;
    }
}
