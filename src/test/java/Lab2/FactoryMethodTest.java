package test.java.Lab2;

import main.java.Lab2.FactoryMethod.EmployeeFactoryMethod;
import main.java.Lab2.FactoryMethod.EmployeeInterface;
import org.junit.jupiter.api.Test;

class FactoryMethodTest {

    @Test
    public void testFactoryMethod(){
        EmployeeFactoryMethod factory = new EmployeeFactoryMethod();
        EmployeeInterface fullTimeEmployee = factory.createEmployee("Mike",28, "Front-end","full_time");

        System.out.println(fullTimeEmployee);
    }

}