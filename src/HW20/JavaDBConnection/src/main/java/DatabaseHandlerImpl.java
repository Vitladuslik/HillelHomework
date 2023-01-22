import com.mysql.cj.jdbc.MysqlDataSource;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandlerImpl implements DatabaseHandler {

    private static final String serverTimeZone = "UTC";
    private static final String serverName = "localhost"; // ip address db
    private static final String databaseName = "Student"; // bd name
    private static final int portNumber = 3306; // db port
    private static final String user = "root"; // login
    private static final String password = "rootroot"; // password
    private MysqlDataSource dataSource = new MysqlDataSource();

    @Override
    public boolean addStudent(Student student) {

        try {

            initDatasource(dataSource);
            Connection connection = dataSource.getConnection();

            if (student.getId() != 0) {
                PreparedStatement ps = connection.prepareStatement("insert into  students (id, name, applied) value  (?, ?, ?)");

                ps.setInt(1, student.getId());
                ps.setString(2, student.getName());
                ps.setInt(3, student.getApplied());
                ps.executeUpdate();
            } else if (student.getId() == 0) {
                PreparedStatement ps = connection.prepareStatement("insert into  students (name, applied) value  (?, ?)");

                ps.setString(1, student.getName());
                ps.setInt(2, student.getApplied());
                ps.executeUpdate();
            }

            connection.close();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean deleteStudentById(int id) {

        try {
            initDatasource(dataSource);
            Connection connection = dataSource.getConnection();

            PreparedStatement ps = connection.prepareStatement("delete from students where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

            connection.close();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public boolean deleteStudentByName(String name) {

        try {
            initDatasource(dataSource);
            Connection connection = dataSource.getConnection();

            PreparedStatement ps = connection.prepareStatement("delete from students where name = ?");
            ps.setString(1, name);
            ps.executeUpdate();

            connection.close();
            return true;

        } catch (SQLException e) {
            return false;
        }

    }

    @Override
    public List<Student> getAll() {

        try {
            initDatasource(dataSource);
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from students");

            return getStudents(connection, rs);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<Student> getByName(String name) {

        try {
            initDatasource(dataSource);
            Connection connection = dataSource.getConnection();

            PreparedStatement ps = connection.prepareStatement("select * from students where name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            return getStudents(connection, rs);
        } catch (SQLException e) {
            return null;
        }
    }


    @Override
    public List<Student> getByIds(List<Integer> ids) {

        try {
            initDatasource(dataSource);
            Connection connection = dataSource.getConnection();

            List<Student> students = new ArrayList<>();

            PreparedStatement ps = connection.prepareStatement("select * from students where id = ?");

            for (Integer integer : ids) {
                ps.setInt(1, integer);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String studentName = rs.getString("name");
                    int applied = rs.getInt("applied");
                    students.add(new Student(id, studentName, applied));
                }
            }

            connection.close();
            return students;
        } catch (SQLException e) {
            return null;
        }
    }

    private void initDatasource(MysqlDataSource ds) throws SQLException {

        ds.setUseSSL(false);
        ds.setServerTimezone(serverTimeZone);
        ds.setServerName(serverName);
        ds.setDatabaseName(databaseName);
        ds.setPortNumber(portNumber);
        ds.setUser(user);
        ds.setPassword(password);

    }

    @NotNull
    private List<Student> getStudents(Connection connection, ResultSet rs) throws SQLException {
        List<Student> students = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("id");
            String studentName = rs.getString("name");
            int applied = rs.getInt("applied");
            students.add(new Student(id, studentName, applied));
        }

        connection.close();
        return students;
    }

}
