import java.util.Scanner;

class Employee {
    // Instance variables
    private String name;
    private int employeeId;
    private String joiningDate;
    private String department;
    private double feedbackScore;
    private double salary;
    private int yearsInOrg;
    private double increment;
    private boolean promotionStatus;

    // Static variable
    private static String organizationName = "TechCorp";

    // Constructor
    public Employee(String name, int employeeId, String joiningDate, String department, double feedbackScore, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.joiningDate = joiningDate;
        this.department = department;
        this.feedbackScore = feedbackScore;
        this.salary = salary;
        this.yearsInOrg = calculateYearsInOrg();

        // Static class sets increment directly as instance variable
        new Increment(this);

        // Non-static class sets promotion status directly as instance variable
        new Promotion();
    }

    // Method to display employee details along with promotion status
    public void display() {
        // Display all details
        System.out.println("\nEmployee Details:");
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Joining Date: " + joiningDate);
        System.out.println("Department: " + department);
        System.out.println("Feedback Score: " + feedbackScore);
        System.out.println("Salary: $" + salary);
        System.out.println("Years in Organization: " + yearsInOrg);
        System.out.println("Organization: " + organizationName);
        System.out.println("Increment: $" + increment);
        System.out.println("Promotion Status: " + (promotionStatus ? "Promoted" : "Not Promoted"));
    }

    // Method to calculate the number of years the employee has been in the organization
    private int calculateYearsInOrg() {
        // For simplicity, assuming current year is 2024 and the joining year is extracted from joiningDate
        String[] dateParts = joiningDate.split("-");
        int joiningYear = Integer.parseInt(dateParts[0]);
        return 2024 - joiningYear;  // Assuming current year is 2024
    }

    // Static nested class: Increment
    static class Increment {
        // Constructor takes Employee object and sets the increment instance variable directly
        public Increment(Employee emp) {
            double incrementPercentage = 0.05 * emp.yearsInOrg + 0.1 * emp.feedbackScore;
            emp.increment = emp.salary * incrementPercentage;
        }
    }

    // Non-static nested class: Promotion
    class Promotion {
        // Constructor sets the promotion status directly in the Employee instance
        public Promotion() {
            Employee.this.promotionStatus = (increment / salary) > 0.5;
        }
    }

    public static void main(String[] args) {
        // Scanner object to take input
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.println("Enter Employee Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Employee ID:");
        int employeeId = scanner.nextInt();

        scanner.nextLine();  // Consume newline

        System.out.println("Enter Joining Date (YYYY-MM-DD):");
        String joiningDate = scanner.nextLine();

        System.out.println("Enter Department:");
        String department = scanner.nextLine();

        System.out.println("Enter Feedback Score (0 to 5):");
        double feedbackScore = scanner.nextDouble();

        System.out.println("Enter Salary:");
        double salary = scanner.nextDouble();

        // Creating an employee object with the user input
        Employee emp1 = new Employee(name, employeeId, joiningDate, department, feedbackScore, salary);

        // Display employee details along with promotion status
        emp1.display();

        scanner.close();
    }
}