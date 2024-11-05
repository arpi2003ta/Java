public abstract class Faculty {
    protected String name;
    protected int facultyId;

    public Faculty(String name, int facultyId) {
        this.name = name;
        this.facultyId = facultyId;
    }

    public void display() {
        System.out.println("Faculty Name: " + name);
        System.out.println("Faculty ID: " + facultyId);
    }

    public abstract void teach(int semester); // Abstract method to be implemented in the subclass
}
