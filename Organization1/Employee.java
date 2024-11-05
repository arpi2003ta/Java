package Organization1;

import java.util.Date;

public class Employee {
    protected int employeeId;
    protected String name;
    protected Date dob;
    protected String department;

    public Employee(int employeeId, String name, Date dob, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.dob = dob;
        this.department = department;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("DOB: " + dob);
        System.out.println("Department: " + department);
    }
}
