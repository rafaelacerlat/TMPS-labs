package test.java.Lab2;

import main.java.Lab2.AbstractFactory.EmployeeFactory;
import main.java.Lab2.AbstractFactory.ManagerFactory;
import main.java.Lab2.AbstractFactory.Member;
import main.java.Lab2.AbstractFactory.MemberFactory;
import org.junit.jupiter.api.Test;

public class AbstractFactoryTest {

    @Test
    public void testAbstractFactory(){
        Member employee3 = MemberFactory.getMember
                (new EmployeeFactory("Sam", 27, "full_time"));
        Member manager = MemberFactory.getMember(new ManagerFactory("John", 33, "full_time"));
        System.out.println(employee3);
        System.out.println(manager);

    }
}
