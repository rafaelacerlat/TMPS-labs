package test.java.CreationalPatterns;

import main.java.CreationalPatterns.AbstractFactory.EmployeeFactory;
import main.java.CreationalPatterns.AbstractFactory.ManagerFactory;
import main.java.CreationalPatterns.AbstractFactory.Member;
import main.java.CreationalPatterns.AbstractFactory.MemberFactory;
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
