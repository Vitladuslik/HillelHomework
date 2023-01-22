import java.sql.SQLException;
import java.util.List;

public interface DatabaseHandler {

    boolean addStudent(Student student);

    boolean deleteStudentById(int id);
    boolean deleteStudentByName(String name);

    List<Student> getAll();

    List<Student> getByName(String name);

    List<Student> getByIds(List<Integer> ids) throws SQLException;

}
