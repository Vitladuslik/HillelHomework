import java.util.ArrayList;
import java.util.List;

public class HibernateRun {
    public static void main(String[] args) {


        DatabaseHandlerImpl handler = new DatabaseHandlerImpl();

        List <Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(4);
        ids.add(2);
        ids.add(3);

        System.out.println(handler.getByIds(ids));
    }
}