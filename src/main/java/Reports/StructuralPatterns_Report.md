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


![structure-en (1)](https://user-images.githubusercontent.com/41265306/205536815-3b121c09-95f6-43ed-872b-376408f96741.png)

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
            emp.showEmployeeDetails();
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

In the end we have the following:
```
@Test
    public void testComposite(){
        IEmployee developer1 = new Developer(1344, "Emma");
        IEmployee developer2 = new Developer(2345,"David");
        IEmployee humanResources = new HumanResources(5890, "Robert");
        IEmployee manager = new Manager(4456, "Mark");

        ((Manager) manager).addEmployee(developer1);
        ((Manager) manager).addEmployee(developer2);
        ((Manager) manager).addEmployee(humanResources);

        manager.getSubordinates();
    }
```

```
Manager: Mark (id=4456) has the following subordinates:
Emma (id=1344) is working as a developer
David (id=2345) is working as a developer
Robert (id=5890) is working as a human resources specialist
```

#### [Decorator](https://github.com/rafaelacerlat/TMPS-labs/tree/main/src/main/java/StructuralPatterns/Project1/Decorator)
A structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.

![structure](https://user-images.githubusercontent.com/41265306/205536958-ac57275f-f672-42f6-bf94-598984f59297.png)



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
In the test part, we initiate an Employee instance and decorate it with WorkQualityParameter one time and PunctualityParameter for one time.
```
@Test
    public void testDecorator(){
        IEmployee employee1 = new Developer(1344, "Emma");

        employee1 = new PunctualityParameter(employee1);
        employee1 = new WorkQualityParameter(employee1);

        System.out.println(employee1.calculateSalary());
    }
```

#### [Adapter](https://github.com/rafaelacerlat/TMPS-labs/tree/main/src/main/java/StructuralPatterns/Project1/Adapter)
A structural design pattern that allows objects with incompatible interfaces to collaborate. It provides solution for helping incompatible things to communicate with each other. It works as an inter-mediator who takes output from one client and gives it to other after converting in the expected format. Adapter pattern is also known as wrapper.


![structure-object-adapter](https://user-images.githubusercontent.com/41265306/205536726-7864620b-3e09-4845-8c52-642e692c1f1c.png)


Let's assume an example of a student who becomes an employee after internship.

We have two model objects Intern.java and Employee.java. Intern model is for storing the student/intern data. Employee model stores the employee data.
```
@Data
@AllArgsConstructor
public class Intern {
    private long id;
    private String name;
    private String internshipType;
}
```
We needed another code which can do the magic of converting intern to employee.
```
public class EmployeeAdapter {

    public static IEmployee process(Intern student){
        IEmployee employee = null;
        
        if(student.getInternshipType().equalsIgnoreCase("developer")){
            employee = new Developer(student.getId(), student.getName());
        }
        else if(student.getInternshipType().equalsIgnoreCase("hr")){
            employee = new HumanResources(student.getId(), student.getName());
        }
        else if(student.getInternshipType().equalsIgnoreCase("manager")){
            employee = new Manager(student.getId(), student.getName());
        }
        return employee;
    }
}
```
So, the adapter design pattern has benefits such as:
1. Helps to reuse existing code
2. Incompatible code can communicate with each other
3. Alternate form of the class creation is possible
4. Makes things work after they're designed


#### [Bridge](https://github.com/rafaelacerlat/TMPS-labs/tree/main/src/main/java/StructuralPatterns/Project2/Bridge)
A structural design pattern that lets you split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation—which can be developed independently of each other.

The client (RefinedAbstraction) code can access only the Abstraction part without being concerned about the Implementation part. The abstraction and implementor are an interface or abstract class. The abstraction contains a reference to the implementor(Implementor implementation)
![structure-en](https://user-images.githubusercontent.com/41265306/205536554-448e3656-29fb-408e-a698-1e38446e6d8b.png)






