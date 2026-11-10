package DesignPattern.StructuralDesignPattern.CompositePattern;

import java.util.ArrayList;
import java.util.List;

//Component
abstract class EmployeeComponent{
    public abstract void displayInfo();
    public abstract double calculateSalary();
}

//Concrete Component -leaf

class Employee extends EmployeeComponent {
    private String name;
    private double salary;

    public Employee(String empName, double empSalary) {
        name = empName;
        salary = empSalary;
    }

    @Override
    public void displayInfo() {
        System.out.println("Employee: " + name + " Salary: Rs." + salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}

//Composite - leaf+ List<Component>
class Department extends EmployeeComponent {
    private String name;
    private List<EmployeeComponent> members;

    public Department(String deptName) {
        name = deptName;
        members = new ArrayList<>();
    }

    public void addMember(EmployeeComponent member) {
        members.add(member);
    }

    @Override
    public void displayInfo() {
        System.out.println("Department: " + name);
        for (EmployeeComponent member : members) {
            member.displayInfo();
        }
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0.0;
        for (EmployeeComponent member : members) {
            totalSalary += member.calculateSalary();
        }
        return totalSalary;
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        EmployeeComponent sanju=new Employee("Sanju",5000);
        EmployeeComponent shrinithi=new Employee("Shrinithi",1000);

        Department headOffice = new Department("Head Office");
        headOffice.addMember(sanju);
        headOffice.addMember(shrinithi);

        headOffice.displayInfo();
        System.out.println("Total Salary for the Organization: $" + headOffice.calculateSalary());
    }
}
