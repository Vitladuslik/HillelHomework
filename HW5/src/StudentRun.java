public class StudentRun {

    public static Object[] students;
    public static StudentService service;

    public static void main(String[] args) {

        students = new Object[10];
        service = new StudentService();




    }

    private static void initStudents() {
        Student student1 = new Student(1,"Korolev","Anton", "Vasil'evich", 1994, "Konovalca, 22", "0984531216","Physics",
                1,2);
        Student student2 = new Student(2,"Korolev","Anton", "Vasil'evich", 1994, "Konovalca, 22", "0984531216","Physics",
                1,2);
        Student student3 = new Student(3,"Korolev","Anton", "Vasil'evich", 1994, "Konovalca, 22", "0984531216","Physics",
                1,2);
        Student student4 = new Student(4,"Korolev","Anton", "Vasil'evich", 1994, "Konovalca, 22", "0984531216","Physics",
                1,2);
        Student student5 = new Student(5,"Korolev","Anton", "Vasil'evich", 1994, "Konovalca, 22", "0984531216","Physics",
                1,2);
        Student student6 = new Student(6,"Korolev","Anton", "Vasil'evich", 1994, "Konovalca, 22", "0984531216","Physics",
                1,2);
        Student student7 = new Student(7,"Korolev","Anton", "Vasil'evich", 1994, "Konovalca, 22", "0984531216","Physics",
                1,2);
        Student student8 = new Student(8,"Korolev","Anton", "Vasil'evich", 1994, "Konovalca, 22", "0984531216","Physics",
                1,2);
        Student student9 = new Student(9,"Korolev","Anton", "Vasil'evich", 1994, "Konovalca, 22", "0984531216","Physics",
                1,2);
        Student student10 = new Student(10,"Korolev","Anton", "Vasil'evich", 1994, "Konovalca, 22", "0984531216","Physics",
                1,2);

        students[0] = student1;
        students[1] = student2;
        students[2] = student3;
        students[3] = student4;
        students[4] = student5;
        students[5] = student6;
        students[6] = student7;
        students[7] = student8;
        students[8] = student9;
        students[9] = student10;


    }

}