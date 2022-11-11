package main.java.CreationalPatterns.AbstractFactory;


public class MemberFactory {

    public static Member getMember(MemberAbstractFactory factory){
        return factory.createCompanyMember();
    }
}
