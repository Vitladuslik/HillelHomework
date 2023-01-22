import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {


        DatabaseHandlerImpl service = new DatabaseHandlerImpl();


        service.deleteStudentByName("John Cena");

        System.out.println(service.getByName("John Cena"));
    }

}
