package StructuralPatterns;

import StructuralPatterns.Project1.Composite.Developer;
import StructuralPatterns.Project1.Composite.HumanResources;
import StructuralPatterns.Project1.Composite.Manager;
import StructuralPatterns.Project1.IEmployee;
import org.junit.jupiter.api.Test;

public class CompositeTest {


    @Test
    public void testComposite(){
        IEmployee developer1 = new Developer(1344, "Emma");
        IEmployee developer2 = new Developer(2345,"David");
        IEmployee humanResources = new HumanResources(5890, "Robert");
        IEmployee manager = new Manager(4456, "Mark");

        ((Manager) manager).addEmployee(developer1);
        ((Manager) manager).addEmployee(developer2);
        ((Manager) manager).addEmployee(humanResources);

        manager.showEmployeeDetails();
    }
}
