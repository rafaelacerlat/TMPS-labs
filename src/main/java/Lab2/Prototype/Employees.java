package main.java.Lab2.Prototype;
import java.util.ArrayList;
import java.util.List;
import Lab2.Builder.Employee;

public class Employees implements Cloneable{

    private List<Employee> empList;

    public Employees(){
        empList = new ArrayList<>();
    }

    public Employees(List<Employee> list){
        this.empList = list;
    }
    public void loadData(Employee employee){
        empList.add(employee);
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        List<Employee> temp = new ArrayList<>();
        for(Employee employee : this.getEmpList()){
            temp.add(employee);
        }
        return new Employees(temp);
    }

}
