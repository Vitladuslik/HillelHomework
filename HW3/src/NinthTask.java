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
        for (int x = 0; x < num.length - 1; x++) {
            if (num[x] == minValue) {
                result[counter] = x;
                counter++;
            }
        }
    }
}
