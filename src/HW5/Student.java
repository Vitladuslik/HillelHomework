package HW5;

public class Student {

    private int id;
    private String lastName;
    private String firstName;
    private String fathersName;
    private int birthYear;
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private int group;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Student() {
    }

    public Student(int id, String lastName, String firstName, String fathersName,
                   int birthYear, String address, String phone, String faculty, int course, int group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.fathersName = fathersName;
        this.birthYear = birthYear;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    @Override
    public String toString() {
        return
                "id=" + id + " "+ lastName + " " + firstName + " " + fathersName +
                ", birthYear = " + birthYear +
                ", address = '" + address + '\'' +
                ", phone = " + phone +
                ", faculty = '" + faculty + '\'' +
                ", course = " + course +
                ", group = " + group;
    }
}
