public class Hod extends Faculty implements Admin {

    public Hod(String name, int facultyId) {
        super(name, facultyId);
    }

    @Override
    public void selectCR(int year, String section) {
        System.out.println("Selecting CR for Year: " + year + ", Section: " + section);
    }

    @Override
    public void teach(int semester) {
        System.out.println(name + " is teaching semester: " + semester);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("HOD of " + COLLEGE_NAME);
    }
}
