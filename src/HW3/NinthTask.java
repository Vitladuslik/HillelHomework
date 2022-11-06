package HW3;

import java.util.Arrays;

public class NinthTask {

    static int[] num = new int[]{1, 10, 6, 4, 9, 1, 8, 3, 10};
    static int minValue;
    static int counter;
    static int[] result;

    public static void main(String[] args) {
        findMinValue();
        findMinValueQuantity();
        getResult();
        System.out.print(Arrays.toString(result));
    }


    private static void findMinValue() {
        minValue = num[0];
        for (int i : num) {
            if (i < minValue) {
                minValue = i;
            }
        }
    }

    private static void findMinValueQuantity() {
        for (int i : num) {
            if (i == minValue) {
                counter++;
            }
        }
    }

    private static void getResult() {
        result = new int[counter];
        counter = 0;
        for (int i : num) {
            if (i == minValue) {
                result[counter] = i;
                counter++;
            }
        }
    }
}
