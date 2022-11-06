package HW7;

import java.util.ArrayList;
import java.util.Arrays;
import jdk.internal.util.ArraysSupport;

import static HW7.Main.arr;


public class ArrayServiceImpl implements ArrayService {

    private int size;
    private int modCount;

    private static final int DEFAULT_CAPACITY = 10;

    //private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    transient Object[] elementData;

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    @Override
    public boolean add(int index, String value) {
        rangeCheckForAdd(index);
        this.elementData = arr;
        modCount++;
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            elementData = grow();
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = value;
        size = s + 1;
        return true;

    }

    @Override
    public boolean add(String value) {

        modCount++;
        add(value, elementData, size);
        return true;


    }

    @Override
    public boolean delete(int index) {


        return true;

    }

    @Override
    public boolean delete(String value) {


        return true;

    }

    @Override
    public String get(int index) {
        return arr[index];
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity = ArraysSupport.newLength(oldCapacity,
                    minCapacity - oldCapacity, /* minimum growth */
                    oldCapacity >> 1           /* preferred growth */);
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    private void add(String value, Object[] elementData, int index) {
        if (index == elementData.length)
            elementData = grow();
        elementData[index] = value;
        size = index + 1;
    }

}
