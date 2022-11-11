package test.java.Lab2;


import main.java.Lab2.Builder.Builder;
import org.junit.jupiter.api.Test;

class BuilderTest {

    @Test
    public void testBuilder(){
        Lab2.Builder.Employee employee1 = new Builder()
                .setName("John")
                .setAge(30)
                .setDepartment("QA")
                .build();
        Lab2.Builder.Employee employee2 = new Builder()
                .setName("Emma")
                .setDepartment("AM")
                .build();

        System.out.println(employee2.toString());
        System.out.println(employee1.toString());
    }


}