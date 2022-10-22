public class TwelfthTask {

    static int[] numbers = new int[]{3, 6, 8, 15, 28};
    static double sum;
    static double average;

    public static void main(String[] args) {

        getSum();
        getAverage();
        output(average);

    }

    private static void getSum() {
        for (int n : numbers) {
            sum+=n;
        }
    }

    private static void getAverage() {
        average = sum / numbers.length;
    }

    private static void output(double average) {
        System.out.println("Average value is : " + average);
    }

}
