import Project.Manager;
import java.util.Date;

public class Main1 {
    public static void main(String[] args) {
        Manager manager1 = new Manager(1, "Alice", new Date(1990, 5, 23), "HR", "Employee Management", 3);
        Manager manager2 = new Manager(2, "Bob", new Date(1985, 10, 5), "IT", "System Upgrade", 5);

        System.out.println("Manager 1 Details:");
        manager1.displayDetails();

        System.out.println("\nManager 2 Details:");
        manager2.displayDetails();
    }
}
