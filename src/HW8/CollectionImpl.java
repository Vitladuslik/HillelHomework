package HW8;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CollectionImpl implements Collection{

    private int size;

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public CollectionImpl() {
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
        if (str == this) {
            return true;
        }
        else if (!(str instanceof List)) {
            return false;
        }
        return false;
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
        return indexOfRange(o, 0, size);
    }

    int indexOfRange(Object o, int start, int end) {
        Object[] es = array;
        if (o == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
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

}
