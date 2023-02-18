import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class DatabaseHandlerImplTest {

    private static SessionFactory sessionFactory = null;
    private static Student testStudent = new Student("Test Testov", 1990, 12);

    @Test
    public void addStudent() {

        DatabaseHandlerImpl service = new DatabaseHandlerImpl();
        Session session = sessionFactory.openSession();

        assertTrue(service.addStudent(testStudent));


        session.beginTransaction();
        session.delete(testStudent);
        session.getTransaction().commit();
        session.close();

    }


    @Test
    public void getAll() {
        DatabaseHandlerImpl service = new DatabaseHandlerImpl();
        Session session = sessionFactory.openSession();
        service.addStudent(testStudent);

        assertNotNull(service.getAll());
        assertNotEquals(0, service.getAll().size());

        session.beginTransaction();
        session.delete(testStudent);
        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void getByName() {

        DatabaseHandlerImpl service = new DatabaseHandlerImpl();
        Session session = sessionFactory.openSession();
        service.addStudent(testStudent);

        assertEquals(1, service.getByName("Test Testov").size());

        session.beginTransaction();
        session.delete(testStudent);
        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void getByIds() {

        List<Integer> ids = new ArrayList<>();
        ids.add(13);

        DatabaseHandlerImpl service = new DatabaseHandlerImpl();

        assertEquals(1, service.getByIds(ids).size());

    }

    @BeforeEach
    public void setUp() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @AfterEach
    public void tearDown() {
        sessionFactory.close();
    }
}
