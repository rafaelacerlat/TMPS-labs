package main.java.CreationalPatterns.FactoryMethod;

public class EmployeeFactoryMethod {

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
}
