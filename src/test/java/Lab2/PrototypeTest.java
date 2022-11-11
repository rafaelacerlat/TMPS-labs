package test.java.Lab2;

import Lab2.Builder.Employee;
import main.java.Lab2.Builder.Builder;
import main.java.Lab2.Prototype.Employees;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PrototypeTest {
    @Test
    public void testSingleton() {
        Employees employees = new Employees();
        try {
            Employees newEmployees = (Employees) employees.clone();
            newEmployees.loadData(new Builder().setName("Ana").setAge(23).build());
            newEmployees.loadData(new Builder().setAge(33).setDepartment("Full-stack").build());
            List<Lab2.Builder.Employee> list = newEmployees.getEmpList();
            System.out.println(list);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
