public class p2 {
    public static void main(String[] args) {
        // Create an object of Hod
        Hod hod = new Hod("Dr. Smith", 101);

        // Display details of the HOD
        hod.display();

        // Select a Class Representative (CR)
        hod.selectCR(3, "B");

        // Call the teach method
        hod.teach(5);
    }
}
