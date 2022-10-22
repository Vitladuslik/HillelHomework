import java.util.Arrays;

public class EleventhTask {

    static int[] numbers = new int[]{4, -5, 0, 6, 8};
    static int minValue;
    static int minValueIndex;
    static int maxValue;
    static int maxValueIndex;

    public static void main(String[] args) {
        System.out.println("Before : " + Arrays.toString(numbers));
        findMinValue();
        findMaxValue();
        replace();
        System.out.println("After : " + Arrays.toString(numbers));
    }

    private static void findMinValue() {
        minValue = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
                minValueIndex = i;
            }
        }
    }

    private static void findMaxValue() {
        maxValue = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
                maxValueIndex = i;
            }
        }
    }

    private static void replace() {
        numbers[minValueIndex] = maxValue;
        numbers[maxValueIndex] = minValue;
    }

}
