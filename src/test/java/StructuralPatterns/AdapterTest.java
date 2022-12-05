package StructuralPatterns;

import StructuralPatterns.Project1.Adapter.EmployeeAdapter;
import StructuralPatterns.Project1.Adapter.Intern;
import StructuralPatterns.Project1.IEmployee;
import org.junit.jupiter.api.Test;

public class AdapterTest {
    @Test
    public void testAdapter(){
        Intern intern = new Intern(6788, "Anne", "developer");

        IEmployee employee = EmployeeAdapter.process(intern);
        employee.showEmployeeDetails();
    }

}
