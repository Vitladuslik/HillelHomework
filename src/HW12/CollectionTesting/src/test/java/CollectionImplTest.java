import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectionImplTest {

    @Test
    void add() {

        CollectionImpl collection = new CollectionImpl();

        assertTrue(collection.add(null));
        assertNull(collection.get(0));
        assertEquals(1, collection.size());

        assertTrue(collection.add("1"));
        assertNotNull(collection.get(1));
        assertEquals("1", collection.get(1));
        assertEquals(2, collection.size());

    }

    @Test
    void testAdd() {

        CollectionImpl collection = new CollectionImpl();

        assertTrue(collection.add(0, null));
        assertNull(collection.get(0));
        assertEquals(1, collection.size());

        assertTrue(collection.add(1, "0"));
        assertNotNull(collection.get(1));
        assertEquals("0", collection.get(1));
        assertEquals(2, collection.size());

    }

    @Test
    void delete() {

        String[] testSubjects = new String[]{"0", "1", "2"};
        CollectionImpl collection = new CollectionImpl(testSubjects);

        assertTrue(collection.delete("2"));
        assertEquals(2, collection.size());
        assertNull(collection.get(2));

        assertFalse(collection.delete("a"));
        assertEquals(2, collection.size());

    }

    @Test
    void get() {

        String[] testSubjects = new String[]{"0", "1", "2", "3", "4"};
        CollectionImpl collection = new CollectionImpl(testSubjects);

        assertEquals("0", collection.get(0));
        assertEquals("1", collection.get(1));
        assertEquals("2", collection.get(2));
        assertEquals("3", collection.get(3));
        assertEquals("4", collection.get(4));

        assertNotEquals("4", collection.get(0));
        assertNotEquals("3", collection.get(1));
        assertNotEquals("1", collection.get(3));
        assertNotEquals("0", collection.get(4));

        assertNull(collection.get(5));

    }

    @Test
    void contain() {

        String[] testSubjects = new String[]{"0", "1", "2", "3", "4"};
        CollectionImpl collection = new CollectionImpl(testSubjects);

        assertTrue(collection.contain("0"));
        assertTrue(collection.contain("1"));
        assertTrue(collection.contain("2"));
        assertTrue(collection.contain("3"));
        assertTrue(collection.contain("4"));

        assertFalse(collection.contain("5"));

    }

    @Test
    void testEquals() {

        String[] testSubjects = new String[]{"0", "1", "2", "3", "4"};
        CollectionImpl collection1 = new CollectionImpl(testSubjects);
        CollectionImpl collection2 = new CollectionImpl(testSubjects);
        CollectionImpl collection3 = new CollectionImpl();

        assertTrue(collection1.equals(collection2));
        assertTrue(collection2.equals(collection1));

        assertFalse(collection1.equals(collection3));
        assertFalse(collection2.equals(collection3));

    }

    @Test
    void clear() {

        String[] testSubjects = new String[]{"0", "1", "2", "3", "4"};
        CollectionImpl collection = new CollectionImpl(testSubjects);

        assertTrue(collection.clear());
        assertEquals(0, collection.size());
        assertNull(collection.get(0));

        assertNotEquals(1, collection.size());

    }

    @Test
    void size() {

        String[] testSubjects = new String[]{"0", "1", "2", "3", "4"};
        CollectionImpl collection = new CollectionImpl(testSubjects);

        assertEquals(5, collection.size());
        assertNotEquals(3, collection.size());

        collection.clear();

        assertEquals(0, collection.size());
        assertNotEquals(1, collection.size());

    }
}