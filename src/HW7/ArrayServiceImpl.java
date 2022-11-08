package HW7;


import jdk.internal.util.ArraysSupport;

import java.util.Arrays;
import java.util.Objects;

public class ArrayServiceImpl implements ArrayService {

    private String[] array;
    private String blankFiller = "Totally not null";
    private int basicLength = 10;

    private int size;



    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public ArrayServiceImpl() {

        this.array = new String[basicLength];
        for (int count = 0; count < basicLength; count++) {
            array[count] = blankFiller;
        }
        size = basicLength;

    }

    public ArrayServiceImpl(String[] arr) {

        this.array = arr;
        size = arr.length;

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

    @Override
    public boolean add(int index, String value) {

        final int s;
        String[] array;
        if ((s = size) == (array = this.array).length)
            array = grow();
        System.arraycopy(array, index,
                array, index + 1,
                s - index);
        array[index] = value;
        size = s + 1;
        return true;

    }

    @Override
    public boolean add(String value) {

        add(value, array, size);
        return true;

    }

    @Override
    public boolean delete(int index) {

        String[] temp = new String[array.length - 1];
        int newArrayCounter = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == index) continue;
            else {
                temp[newArrayCounter] = array[i];
                newArrayCounter++;
            }
        }
        array = temp;
        return false;

    }


    // метод видаляє перше знайдене співпадіння
    @Override
    public boolean delete(String value) {

        try {
            String[] temp = new String[array.length - 1];
            int newArrayCounter = 0;
            for (String s : array) {
                if (Objects.equals(s, value)) {
                    continue;
                } else {
                    temp[newArrayCounter] = s;
                    newArrayCounter++;
                }
            }
            array = temp;
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    // метод вираховує кількість елементів, які відповідають вказаному,створює новий масив меньший на цю кількість
    // та переносить туди усі інші змінні у тому ж порядку
    public boolean deleteAll(String value) {

        try {
            int matchCount = 0;
            for (String s : array) {
                if (s.equals(value)) {
                    matchCount++;
                }
            }
            String[] temp = new String[array.length - matchCount];
            int newArrayCounter = 0;
            for (String s : array) {
                if (Objects.equals(s, value)) {
                    continue;
                } else {
                    temp[newArrayCounter] = s;
                    newArrayCounter++;
                }
            }
            array = temp;
            return true;
        } catch (Exception e) {
            return false;
        }

    }


    @Override
    public String get(int index) {
        if (index < 0 || index >= array.length) {
            return null;
        }
        return array[index];
    }


}

