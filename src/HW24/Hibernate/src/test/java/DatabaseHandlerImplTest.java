import org.hibernate.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class DatabaseHandlerImplTest {

    @Test
    public void addStudent() {

        DatabaseHandlerImpl service = new DatabaseHandlerImpl();

        Student testStudent = new Student();
        testStudent.setName("Test Testov");
        testStudent.setApplied(1990);
        testStudent.setId(1112);

        assertTrue(service.addStudent(testStudent));

    }


    @Test
    public void getAll() {

        DatabaseHandlerImpl service = new DatabaseHandlerImpl();
        assertNotNull(service.getAll());
        assertNotEquals(0, service.getAll().size());

    }

    @Test
    public void getByName() {

        DatabaseHandlerImpl service = new DatabaseHandlerImpl();

        assertEquals(1, service.getByName("Test Testov").size());

    }

    @Test
    public void getByIds() {

        List<Integer> ids = new ArrayList<>();
        ids.add(13);

        DatabaseHandlerImpl service = new DatabaseHandlerImpl();

        assertEquals(1, service.getByIds(ids).size());

    }

    @BeforeEach
    public void addTestStudent() {

        DatabaseHandlerImpl service = new DatabaseHandlerImpl();
        Student testStudent = new Student();
        testStudent.setName("Test Testov");
        testStudent.setApplied(1990);
        testStudent.setGroupId(22);
        service.addStudent(testStudent);

    }

    @AfterEach
    public void deleteTestStudents() {

        DatabaseHandlerImpl service = new DatabaseHandlerImpl();
        while (service.getByName("Test Testov").size() > 0) {
            Session session = HibernateService.getSessionFactory().openSession();
            session.beginTransaction();

            Student s = session.get(Student.class, "Test Testov");
            session.delete(s);
            session.getTransaction().commit();
        }
    }

}
