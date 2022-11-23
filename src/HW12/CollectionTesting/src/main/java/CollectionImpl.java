import java.util.Arrays;
import java.util.Objects;

public class CollectionImpl implements Collection {

    private int size;

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public CollectionImpl() {

        this.size = 0;
        this.array = new String[10];

    }

    public CollectionImpl(String[] array) {
        this.array = array;
        size = array.length;
    }

    private String[] array;

    @Override
    public boolean add(String o) {

        add(o, array, size);
        return true;

    }

    @Override
    public boolean add(int index, String o) {

        final int s;
        String[] array;
        if ((s = size) == (array = this.array).length)
            array = grow();
        System.arraycopy(array, index,
                array, index + 1,
                s - index);
        array[index] = o;
        size = s + 1;
        return true;

    }

    @Override
    public boolean delete(String o) {

        for ( String string : array) {
            if (string.equals(o)) {
                String[] temp = new String[array.length - 1];
                int newArrayCounter = 0;
                for (String s : array) {
                    if (Objects.equals(s, o)) {
                        continue;
                    } else {
                        temp[newArrayCounter] = s;
                        newArrayCounter++;
                    }
                }
                array = temp;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String get(int index) {

        if (index < 0 || index >= array.length) {
            return null;
        }
        return array[index];

    }

    @Override
    public boolean contain(String o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean equals(Collection str) {
        if (this == str) return true;
        if (str == null || getClass() != str.getClass()) return false;
        CollectionImpl that = (CollectionImpl) str;
        return size == that.size && Arrays.equals(array, that.array);
    }

    @Override
    public boolean clear() {
        final Object[] es = array;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    private void add(String s, String[] array, int index) {
        if (index == array.length)
            array = grow();
        array[index] = s;
        size = index + 1;
    }

    private String[] grow() {

        int newCapacity = (int) (array.length*1.2);
        return array = Arrays.copyOf(array, newCapacity);
    }

    public int indexOf(Object o) {
        return indexOfRange(o, size);
    }

    int indexOfRange(Object o, int end) {
        Object[] es = array;
        if (o == null) {
            for (int i = 0; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < end; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public String toString() {
        return Arrays.toString(array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}
