package test.java.CreationalPatterns;

import main.java.CreationalPatterns.FactoryMethod.EmployeeFactoryMethod;
import main.java.CreationalPatterns.FactoryMethod.EmployeeInterface;
import org.junit.jupiter.api.Test;

class FactoryMethodTest {

    @Test
    public void testFactoryMethod(){
        EmployeeFactoryMethod factory = new EmployeeFactoryMethod();
        EmployeeInterface fullTimeEmployee = factory.createEmployee("Mike",28, "Front-end","full_time");

        System.out.println(fullTimeEmployee);
    }

}