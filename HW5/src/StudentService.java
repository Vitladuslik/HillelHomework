public class StudentService {

    public void findStudentsByFaculty(String faculty) {
        for (int count = 0; count<StudentRun.students.length; count++) {
            String temp = StudentRun.students[count].toString();
            if (temp.indexOf(faculty) > 0) {
                System.out.println(StudentRun.students[count]);
            }
        }
    }

    public void findStudentsByFacultyAndCourse(String faculty, int course) {

        for (int count = 0; count<StudentRun.students.length; count++) {
            String temp = StudentRun.students[count].toString();
            if (temp.indexOf(faculty) > 0 & temp.indexOf(course) > 0) {
                System.out.println(StudentRun.students[count]);
            }
        }

    }

    public void findStudentsBornAfter(int year) {

        for (int count = 0; count<StudentRun.students.length; count++) {
            String temp = StudentRun.students[count].toString();
            if (temp.indexOf(year) > 0) {
                System.out.println(StudentRun.students[count]);
            }
        }

    }

    public void findStudentsByGroup(String group) {

        for (int count = 0; count<StudentRun.students.length; count++) {
            String temp = StudentRun.students[count].toString();
            if (temp.indexOf(group) > 0) {
                System.out.println(StudentRun.students[count]);
            }
        }

    }

}
