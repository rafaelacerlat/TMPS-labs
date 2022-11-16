# Topic: Creational Design Patterns

### Course: Software Design Techniques and Mechanisms
### Author: Rafaela Cerlat

----

## Implementation

* Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists. 
```
// The constructor is private so that this class cannot be instantiated (more than one time)
    private Singleton(String value) {
        this.value = value;
    }
```
The class must provide a global access point to get the instance of the class. 
```
  public static Singleton getInstance(String value) {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(value);
                }
            }
        }
        return instance;
    }
```
Singleton pattern is used for logging, drivers objects, caching, and thread pool.

* Builder is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.

It suggests that you extract the object construction code out of its own class and move it to separate objects called builders.
For example there is the Employee class and the Builder class that allows construction of Employee in a different ways.

```
Lab2.Builder.Employee employee1 = new Builder()
                .setName("John")
                .setAge(30)
                .setDepartment("QA")
                .build();
Lab2.Builder.Employee employee2 = new Builder()
                .setName("Emma")
                .setDepartment("AM")
                .build();
```

*  Prototype pattern provides a mechanism to copy the original object to a new object and then modify it according to our needs. Prototype design pattern uses java cloning to copy the object.

As example, we have an Employees class that loads data and stores the employees list. It implements the Cloneable interface.
```
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
```
The clone method is overridden to provide a deep copy of the employees list.

* Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. The Factory Method pattern suggests that you replace direct object construction calls (using the new operator) with calls to a special factory method. The objects are still created via the new operator, but it’s being called from within the factory method. Objects returned by a factory method are often referred to as products.

So, for example, there is an Employee interface, and 3 types of employees: Contractor, Part-time and Full-time. The EmployeeFactoryMethod has a method called createEmployee() that creates the objects based on their type.
```
    public EmployeeInterface createEmployee(String name, int age, String department, String type) {
        EmployeeInterface employee;
        switch(type) {
            case "part_time":
                employee = new PartTimeEmployeeInterface(name, age, department, type);
                break;
            case "full_time":
                employee = new FullTimeEmployeeInterface(name, age, department, type);
                break;
            case "contractor":
                employee = new ContractorEmployeeInterface(name, age, department, type);
                break;
            default:
                throw new IllegalArgumentException("No such employee");
        }
        System.out.println(employee);
        return employee;
    }
 ```

* The Abstract Factory defines a Factory Method per product. Each Factory Method encapsulates the new operator and the concrete, platform-specific, product classes. Each "platform" is then modeled with a Factory derived class.


