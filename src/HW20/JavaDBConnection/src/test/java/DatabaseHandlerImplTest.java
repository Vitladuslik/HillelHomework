import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandlerImplTest {

    @Test
    public void addStudent() {

        DatabaseHandlerImpl service = new DatabaseHandlerImpl();

        Student testStudent = new Student();
        testStudent.setName("Test Testov");
        testStudent.setApplied(1990);
        testStudent.setId(1112);

        assertTrue(service.addStudent(testStudent));

        service.deleteStudentByName("Test Testov");

    }

    @Test
    public void deleteStudentById() {

        List<Integer> ids = new ArrayList<>();
        ids.add(1111);

        DatabaseHandlerImpl service = new DatabaseHandlerImpl();

        assertEquals(1, service.getByIds(ids).size());
        assertTrue(service.deleteStudentById(1111));
        assertEquals(0, service.getByIds(ids).size());

    }

    @Test
    public void deleteStudentByName() {

        DatabaseHandlerImpl service = new DatabaseHandlerImpl();

        assertEquals(1, service.getByName("Test Testov").size());
        assertTrue(service.deleteStudentByName("Test Testov"));
        assertEquals(0, service.getByName("Test Testov").size());

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
        ids.add(1111);

        DatabaseHandlerImpl service = new DatabaseHandlerImpl();

        assertEquals(1, service.getByIds(ids).size());

    }

    @BeforeEach
    public void addTestStudent() {

        DatabaseHandlerImpl service = new DatabaseHandlerImpl();
        Student testStudent = new Student();
        testStudent.setName("Test Testov");
        testStudent.setApplied(1990);
        testStudent.setId(1111);
        service.addStudent(testStudent);

    }

    @AfterEach
    public void deleteTestStudents() {

        DatabaseHandlerImpl service = new DatabaseHandlerImpl();
        while (service.getByName("Test Testov").size() > 0) {
            service.deleteStudentByName("Test Testov");
        }
    }

}
