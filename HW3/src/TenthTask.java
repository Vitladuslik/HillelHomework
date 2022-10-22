import java.util.Arrays;

public class TenthTask {

    static int[] num = new int[]{1, 10, 6, 4, 9, 1, 8, 3, 10};
    static int maxValue;
    static int counter;
    static int[] result;

    public static void main(String[] args) {
        findMaxValue();
        findMaxValueQuantity();
        getResult();
        System.out.print(Arrays.toString(result));
    }


    private static void findMaxValue() {
        maxValue = num[0];
        for (int i : num) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
    }

    private static void findMaxValueQuantity() {
        for (int i : num) {
            if (i == maxValue) {
                counter++;
            }
        }
    }

    private static void getResult() {
        result = new int[counter];
        counter = 0;
        for (int i : num) {
            if (i == maxValue) {
                result[counter] = i;
                counter++;
            }
        }
    }
}
