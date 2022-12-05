package StructuralPatterns.Project1.Composite;

import StructuralPatterns.Project1.IEmployee;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Manager implements IEmployee {
    private long id;
    private String name;
    private List<IEmployee> employeeList = new ArrayList<>();

    public Manager(long id, String name)
    {
        this.id = id;
        this.name = name;
    }
    @Override
    public void showEmployeeDetails() {
        System.out.println(name + " (id=" + id + ") is working as a manager");
    }

    @Override
    public void getSubordinates()
    {
        System.out.println("Manager: " + name + " (id=" + id + ") has the following subordinates:");
        for(IEmployee emp:employeeList)
        {
            emp.showEmployeeDetails();
        }
    }

    @Override
    public double calculateSalary() {
        return 20000;
    }

    public void addEmployee(IEmployee emp)
    {
        employeeList.add(emp);
    }

    public void removeEmployee(IEmployee emp)
    {
        employeeList.remove(emp);
    }
}
