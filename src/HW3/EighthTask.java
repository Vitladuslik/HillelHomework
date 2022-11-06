package HW3;

import java.util.Arrays;

public class EighthTask {

    static int[] numbers;
    static int x;

    public static void main(String[] args) {
        numbers = new int[10];
        x = 1;
        for (int counter = 0; counter < 10; counter++) {
            numbers[counter] = x;
            x += 2;
        }
        System.out.println(Arrays.toString(numbers).substring(1, 34));
    }

}
