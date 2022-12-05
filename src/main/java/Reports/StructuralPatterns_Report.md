# Topic: Structural Design Patterns

### Course: Software Design Techniques and Mechanisms
### Author: Rafaela Cerlat

----

## Implementation

#### [Composite](https://github.com/rafaelacerlat/TMPS-labs/tree/main/src/main/java/StructuralPatterns/Project1/Composite)
A structural design pattern that lets you compose objects into tree structures and then work with these structures as if they were individual objects.
The Composite Pattern has four participants:

1. **Component** – declares the interface for objects in the composition and for accessing and managing its child components. It also implements default behavior for the interface common to all classes as appropriate.
2. **Leaf** – defines behavior for primitive objects in the composition. It represents leaf objects in the composition.
3. **Composite** – stores child components and implements child related operations in the component interface.
4. **Client** – manipulates the objects in the composition through the component interface.

For example, let’s assume an organization hierarchy in terms of the Composite Pattern. Let’s assume Manager as Composite, Employee as Component, and Developer or HumanResources as the Leaf. 
First we will create component interface. It represents object in composition.  It has all common operations that will be applicable to both manager and developer.
```
public interface IEmployee {

     void showEmployeeDetails();
     void getSubordinates();
     double calculateSalary();
}
```
Now we will create Manager (composite class).
```
@AllArgsConstructor
public class Manager implements IEmployee {
    private long id;
    private String name;
    private List<IEmployee> employeeList = new ArrayList<>();

    public Manager(long id, String name)
    {
        this.id = id;
        this.name = name;
    }
    @Override
    public void showEmployeeDetails() {
        System.out.println(name + " (id=" + id + ") is working as a manager");
    }

    @Override
    public void getSubordinates()
    {
        System.out.println("Manager: " + name + " (id=" + id + ") has the following subordinates:");
        for(IEmployee emp:employeeList)
        {
            emp.getSubordinates();
        }
    }

    @Override
    public double calculateSalary() {
        return 20000;
    }

    public void addEmployee(IEmployee emp)
    {
        employeeList.add(emp);
    }

    public void removeEmployee(IEmployee emp)
    {
        employeeList.remove(emp);
    }
}
```
There are methods which are not applicable to Developer because it is a leaf node.


#### [Decorator](https://github.com/rafaelacerlat/TMPS-labs/tree/main/src/main/java/StructuralPatterns/Project1/Decorator)
A structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors. 

So, in the following example it will be used to extend the behavior of a specific object in the Composite tree. We created one decorator for salary points calculation which super typed to the interface Employee
```
public interface EmployeeSalaryCalculatorDecorator extends IEmployee {
     String getDescriptionOfQualityParameter();
}
```
Second, we created concrete decorators for each work quality points and each single object of it represents one single point for final salary calculation.
```
public class PunctualityParameter implements EmployeeSalaryCalculatorDecorator{
    IEmployee employee;

    public PunctualityParameter(IEmployee Employee) {
        this.employee = Employee;
    }
    @Override
    public String getDescriptionOfQualityParameter() {
        return getClass().getSimpleName();
    }
    @Override
    public double calculateSalary() {
        return 1000 + employee.calculateSalary();
    }
  ...
}
```

```
public class WorkQualityParameter implements EmployeeSalaryCalculatorDecorator {
    IEmployee employee;

    public WorkQualityParameter(IEmployee employee) {
        this.employee = employee;
    }
    @Override
    public String getDescriptionOfQualityParameter() {
        return getClass().getSimpleName();
    }

    @Override
    public double calculateSalary() {
        return 1200 + employee.calculateSalary();
    }
  ...
}
```



