import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Painter {

    static String input;
    static Scanner scan = new Scanner(System.in);
    static class Digit {
        String[] lines;

        public Digit(String... lines) {
            this.lines = lines;
        }

        public static Digit[] createDigits(String... lines) {

            int width = (lines[0].length() - 9) / 10;
            return IntStream
                    .range(0, 10)
                    .mapToObj(digit ->
                            new Digit(Stream
                                    .of(lines)
                                    .map(line -> line.substring(digit * (width + 1), (digit + 1) * (width + 1) - 1))
                                    .toArray(String[]::new))
                    ).toArray(Digit[]::new);
        }
    }


    public static void main(String[] args) {

        System.out.print("Please enter your numbers: ");
        input = scan.nextLine();
        isAllNumbers(input);
        paint();

    }
    static public void paint() {

        int[] numbers = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();

        Digit[] digits = Digit.createDigits(
                " @@@@    @@    @@@@   @@@@  @@  @@ @@@@@@  @@@@@ @@@@@@  @@@@   @@@@@",
                      "@@  @@  @@@   @    @ @    @ @@  @@ @@     @@        @@  @    @ @@  @@",
                      "@@  @@ @ @@     @@@     @@  @@@@@@ @@@@@  @@@@@    @@    @@@@   @@@@@",
                      "@@  @@   @@   @@     @    @     @@     @@ @@  @@  @@    @    @     @@",
                      " @@@@  @@@@@@ @@@@@@  @@@@      @@ @@@@@   @@@@  @@      @@@@   @@@@ "
        );

        int height = digits[0].lines.length;


        for (int i = 0; i < height; i++) {
            for (int digit : numbers) {
                System.out.print(digits[digit].lines[i] + " ");
            }
            System.out.println();
        }

    }

    static void isAllNumbers(String input) {
        try {
            Arrays.stream(input.split("")).forEach(Integer::parseInt);
            System.out.println("All numbers can be converted!");
        } catch (NumberFormatException e) {
            System.out.println("Input  cannot be converted to Integer!");
        }

    }


}
