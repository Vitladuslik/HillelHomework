public class StudentService {

    public static void findStudentsByFaculty(String faculty) {
        System.out.println("----------------------------------------------------");
        System.out.println("Students of " + faculty + " faculty:");
        for (Student st : StudentRun.students) {
            if (st.getFaculty().equals(faculty)) {
                System.out.println(st);
            }
        }
        System.out.println("----------------------------------------------------");
    }

    public static void findStudentsByFacultyAndCourse(String faculty, int course) {
        System.out.println("----------------------------------------------------");
        System.out.println("Students of " + faculty + " faculty and " + course + " course: ");
        for (Student st : StudentRun.students) {
            if (st.getFaculty().equals(faculty) && (st.getCourse() == course)) {
                System.out.println(st);
            }
        }
        System.out.println("----------------------------------------------------");
    }

    public static void findStudentsBornAfter(int year) {
        System.out.println("----------------------------------------------------");
        System.out.println("Students born after year " + year + " : ");
        for (Student st : StudentRun.students) {
            if (st.getBirthYear() > year) {
                System.out.println(st);
            }
        }
        System.out.println("----------------------------------------------------");
    }

    public static void findStudentsByGroup(int group) {
        System.out.println("----------------------------------------------------");
        System.out.println("Students in " + group + " group: ");
        for (Student st : StudentRun.students) {
            if (st.getGroup() == group) {
                System.out.println(st);
            }
        }
        System.out.println("----------------------------------------------------");
    }

}
