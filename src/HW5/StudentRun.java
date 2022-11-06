package HW5;

public class StudentRun extends StudentService {

    public static Student[] students;
    public static Student testStudent;

    public static void main(String[] args) {

        initStudents();

        findStudentsByFaculty("Physics");

        findStudentsByFacultyAndCourse("Math", 2);

        findStudentsBornAfter(1996);

        findStudentsByGroup(303);

    }

    private static void initStudents() {

        testStudent = new Student();
        testStudent.setId(1);
        testStudent.setLastName("Korolev");
        testStudent.setFirstName("Anton");
        testStudent.setFathersName("Vasil'evich");
        testStudent.setBirthYear(1994);
        testStudent.setAddress("Konovalca, 22");
        testStudent.setPhone("0987659265");
        testStudent.setFaculty("Physics");
        testStudent.setCourse(1);
        testStudent.setGroup(101);

        students = new Student[]{testStudent,

                new Student(2, "Antonov", "Valentin", "Anatolievich", 1996,
                        "Naberezhna, 41", "0958932650", "Math", 2, 202),

                new Student(3, "Vorobey", "Meriem", "Maksimovich", 1997,
                        "Oblachna, 1/2", "0993389671", "Philosophy", 3, 303),

                new Student(4, "Kuznetsov", "Alex", "Tykhomyrovich", 1996,
                        "Centralna, 15", "0970024376", "Physics", 1, 102),

                new Student(5, "Patton", "Fox", "Valerievich", 1994,
                        "Myrniy, 13", "0980295381", "Biology", 4, 404),

                new Student(6, "Orlyk", "Phylyp", "Pavlovich", 1996,
                        "Unosti, 1", "0968819467", "Math", 1, 201),

                new Student(7, "Synytsa", "Andrey", "Victorovoch", 1998,
                        "Myru, 11a", "0990138275", "Philosophy", 3, 303),

                new Student(8, "Tref", "Alex", "Sergeevich", 1992,
                        "Stara, 18", "0980001532", "Biology", 2, 402),

                new Student(9, "Sumka", "Denis", "Petorich", 1996,
                        "Morska, 6", "0991827364", "Physics", 1, 101),

                new Student(10, "Goldstein", "Rokfor", "Stepanovich", 1994,
                        "Lvivska, 45", "0956574832", "Math", 4, 204)};

    }

}