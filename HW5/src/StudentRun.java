public class StudentRun {

    public static Object[] students;

    public static Student student1;
    public static Student student2;
    public static Student student3;
    public static Student student4;
    public static Student student5;
    public static Student student6;
    public static Student student7;
    public static Student student8;
    public static Student student9;
    public static Student student10;
    public static StudentService service;

    public static void main(String[] args) {

        students = new Object[10];
        service = new StudentService();
        initStudents();
        service.findStudentsByFaculty("Physics");


    }

    private static void initStudents() {
        student1 = new Student(1,"Korolev","Anton", "Vasil'evich", 1994, "Konovalca, 22", "0987659265","Physics",
                1,2);
        student2 = new Student(2,"Antonov","Valentin", "Anatolievich", 1996, "Naberezhna, 41", "0958932650","Math",
                1,2);
        student3 = new Student(3,"Vorobey","Meriem", "Maksimovich", 1997, "Oblachna, 1/2", "0993389671","Philosophy",
                1,2);
        student4 = new Student(4,"Kuznetsov","Alex", "Tykhomyrovich", 1996, "Centralna, 15", "0970024376","Physics",
                1,2);
        student5 = new Student(5,"Patton","Fox", "Valerievich", 1994, "Myrniy, 13", "0980295381","Biology",
                1,2);
        student6 = new Student(6,"Orlyk","Phylyp", "Pavlovich", 1996, "Unosti, 1", "0968819467","Math",
                1,2);
        student7 = new Student(7,"Synytsa","Andrey", "Victorovoch", 1998, "Myru, 11a", "0990138275","Philosophy",
                1,2);
        student8 = new Student(8,"Tref","Alex", "Sergeevich", 1992, "Stara, 18", "0980001532","Biology",
                1,2);
        student9 = new Student(9,"Sumka","Denis", "Petorich", 1996, "Morska, 6", "0991827364","Physics",
                1,2);
        student10 = new Student(10,"Goldstein","Rokfor", "Stepanovich", 1994, "Lvivska, 45", "0956574832","Math",
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