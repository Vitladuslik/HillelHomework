import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameImpl implements Game {

    private static final Scanner scan = new Scanner(System.in);

    public void getPlayerName(Player player) {
        System.out.print("Please enter your name: ");
        player.setName(scan.nextLine());
    }

    public void getGamesCount(Player player) {
        System.out.print("Please enter number of games: ");
        try {
            player.setGamesCount(scan.nextInt());
        } catch (InputMismatchException e) {
            System.err.print("Wrong input! Please restart the app and try again.");
        }
    }

    public void startRound(Player player, Computer computer) {
        int input;
        try {
            System.out.println("""
                    Make your choice:
                    1 - Rock
                    2 - Paper
                    3 - Scissors
                    From 4 to 0 - end game""");
            input = scan.nextInt();
            switch (input) {
                case 1 -> player.setPlayerHand(Hand.ROCK);
                case 2 -> player.setPlayerHand(Hand.PAPER);
                case 3 -> player.setPlayerHand(Hand.SCISSORS);
                default -> {
                    System.out.println("Ending game...");
                    endgame(player, computer);
                    System.exit(0);
                }
            }

            System.out.println(player.getName() + " have chosen " + player.getPlayerHand());

            switch (new Random().nextInt(4 - 1) + 1) {
                case 1 -> computer.setComputerHand(Hand.ROCK);
                case 2 -> computer.setComputerHand(Hand.PAPER);
                case 3 -> computer.setComputerHand(Hand.SCISSORS);
            }

            System.out.println("Computer have chosen " + computer.getComputerHand());

            findVictor(player, computer);

        } catch (InputMismatchException e) {
            System.err.print("Wrong input! Please restart the app and try again.");
        }
    }

    public void findVictor(Player player, Computer computer) {
        if (player.getPlayerHand() == Hand.ROCK && computer.getComputerHand() == Hand.SCISSORS ||
                player.getPlayerHand() == Hand.SCISSORS && computer.getComputerHand() == Hand.PAPER ||
                player.getPlayerHand() == Hand.PAPER && computer.getComputerHand() == Hand.ROCK) {
            System.out.println(player.getName() + " wins!");
            System.out.println("-------------------------------------------------------");
            player.setPlayerWins(player.getPlayerWins() + 1);
            player.setTotalGamesPlayed(player.getTotalGamesPlayed() + 1);
        } else if (player.getPlayerHand() == computer.getComputerHand()) {
            System.out.println("Draw!");
            startRound(player, computer);
        } else {
            System.out.println("Computer wins!");
            System.out.println("-------------------------------------------------------");
            computer.setComputerWins(computer.getComputerWins() + 1);
            player.setTotalGamesPlayed(player.getTotalGamesPlayed() + 1);
        }
    }


    public void endgame(Player player, Computer computer) {
        System.out.printf("Player %s won %d games, lost %d games. Total games played: %d",
                player.getName(), player.getPlayerWins(), computer.getComputerWins(), player.getTotalGamesPlayed());
    }

}
