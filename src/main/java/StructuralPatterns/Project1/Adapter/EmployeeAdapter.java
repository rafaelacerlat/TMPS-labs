package StructuralPatterns.Project1.Adapter;

import StructuralPatterns.Project1.Composite.Developer;
import StructuralPatterns.Project1.Composite.HumanResources;
import StructuralPatterns.Project1.Composite.Manager;
import StructuralPatterns.Project1.IEmployee;

public class EmployeeAdapter {

    public static IEmployee process(Intern student){
        IEmployee employee = null;
        
        if(student.getInternshipType().equalsIgnoreCase("developer")){
            employee = new Developer(student.getId(), student.getName());
        }
        else if(student.getInternshipType().equalsIgnoreCase("hr")){
            employee = new HumanResources(student.getId(), student.getName());
        }
        else if(student.getInternshipType().equalsIgnoreCase("manager")){
            employee = new Manager(student.getId(), student.getName());
        }
        return employee;
    }
}
