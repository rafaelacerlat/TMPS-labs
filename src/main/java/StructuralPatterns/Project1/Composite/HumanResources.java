package StructuralPatterns.Project1.Composite;

import StructuralPatterns.Project1.IEmployee;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HumanResources implements IEmployee {
    private long id;
    private String name;

    @Override
    public void showEmployeeDetails() {
        System.out.println(name + " (id=" + id + ") is working as a human resources specialist");
    }

    @Override
    public void getSubordinates()
    {
        System.out.println(name + "is a HR, without any subordinates");
    }

    @Override
    public double calculateSalary() {
        return 6000;
    }
}
