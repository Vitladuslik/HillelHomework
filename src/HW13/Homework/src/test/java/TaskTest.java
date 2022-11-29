import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TaskTest {

    @Test
    void average() {

        Task solution = new Task();
        List<Integer> testIntegers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals(5.5, solution.average(testIntegers));
        assertEquals(0, solution.average(null));
        assertNotEquals(6, solution.average(testIntegers));
        assertNotEquals(1, solution.average(null));

    }

    @Test
    void upperCase() {

        Task solution = new Task();
        List<String> testString = List.of("a", "b", "c", "d", "e");

        assertEquals(new Pair("a", "A"), solution.upperCase(testString).get(0));
        assertEquals(new Pair("b", "B"), solution.upperCase(testString).get(1));
        assertEquals(new Pair("c", "C"), solution.upperCase(testString).get(2));
        assertEquals(new Pair("d", "D"), solution.upperCase(testString).get(3));
        assertEquals(new Pair("e", "E"), solution.upperCase(testString).get(4));
        assertNotNull(solution.upperCase(testString));
        assertNull(solution.upperCase(null));

    }

    @Test
    void filter() {

        Task solution = new Task();
        List<String> testString = List.of("Amber", "book", "cLever", "dEEp", "eye");

        assertTrue(solution.filter(testString));
        assertFalse(solution.filter(null));

    }

}
