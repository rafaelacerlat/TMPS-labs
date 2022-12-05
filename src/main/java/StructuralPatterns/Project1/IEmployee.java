package StructuralPatterns.Project1;

/**
 * Manager(Composite)
 * Developer(Leaf)
 * HumanResources(Leaf)
 * Employee(Component)
 */

public interface IEmployee {

     void showEmployeeDetails();
     void getSubordinates();
     double calculateSalary();


}