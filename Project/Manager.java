package Project;

import Organization1.Employee;
import java.util.Date;

public class Manager extends Employee {
    private String projectName;
    private int noOfTeams;

    public Manager(int employeeId, String name, Date dob, String department, String projectName, int noOfTeams) {
        super(employeeId, name, dob, department);
        this.projectName = projectName;
        this.noOfTeams = noOfTeams;
    }

    
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Project Name: " + projectName);
        System.out.println("Number of Teams: " + noOfTeams);
    }
}
