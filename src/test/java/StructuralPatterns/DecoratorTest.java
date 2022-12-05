package StructuralPatterns;

import StructuralPatterns.Project1.Composite.Developer;
import StructuralPatterns.Project1.Decorator.PunctualityParameter;
import StructuralPatterns.Project1.Decorator.WorkQualityParameter;
import StructuralPatterns.Project1.IEmployee;
import org.junit.jupiter.api.Test;

public class DecoratorTest {

    @Test
    public void testDecorator(){
        IEmployee employee1 = new Developer(1344, "Emma");

        employee1 = new PunctualityParameter(employee1);
        employee1 = new WorkQualityParameter(employee1);

        System.out.println(employee1.calculateSalary());
    }
}
