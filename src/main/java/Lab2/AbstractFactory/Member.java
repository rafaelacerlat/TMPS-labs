package main.java.Lab2.AbstractFactory;

public abstract class Member {

    public abstract String getName();
    public abstract int getAge();
    public abstract String getType();

    @Override
    public String toString() {
        return "Member{" +
                "name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                ", type ='" + this.getType() + '\'' +
                '}';
    }
}
