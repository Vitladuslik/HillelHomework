package HW3;

public class ThirteenthTask {

    static int line;

    public static void main(String[] args) {

        String[][] chess = new String[][]{
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"},
                {"W", "B", "W", "B", "W", "B", "W", "B"},
                {"B", "W", "B", "W", "B", "W", "B", "W"}
        };

        for (int x = 0; x < 9; x++) {
            if (x == 8) {
                if (line == 7) {
                    break;
                } else {
                    line++;
                    x = 0;
                    System.out.println();
                }
            }
            System.out.print(chess[line][x] + "  ");
        }

    }

}
