package main.java.Lab2.AbstractFactory;


public class MemberFactory {

    public static Member getMember(MemberAbstractFactory factory){
        return factory.createCompanyMember();
    }
}
