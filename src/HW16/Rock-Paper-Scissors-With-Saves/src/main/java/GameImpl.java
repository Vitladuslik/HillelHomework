import lombok.NoArgsConstructor;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

@NoArgsConstructor
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
            System.err.println(player.getName() + " wins!");
            System.out.println("-------------------------------------------------------");
            player.setPlayerWins(player.getPlayerWins() + 1);
            player.setTotalGamesPlayed(player.getTotalGamesPlayed() + 1);
        } else if (player.getPlayerHand() == computer.getComputerHand()) {
            System.err.println("Draw! Try again!");
            startRound(player, computer);
        } else {
            System.err.println("Computer wins!");
            System.out.println("-------------------------------------------------------");
            computer.setComputerWins(computer.getComputerWins() + 1);
            player.setTotalGamesPlayed(player.getTotalGamesPlayed() + 1);
        }
    }


    public void endgame(Player player, Computer computer) {
        String result = "Player " + player.getName() + " won " + player.getPlayerWins()
                + " games, lost " + computer.getComputerWins() + " games. Total games played: "
                + player.getTotalGamesPlayed() + ".";
        System.out.println(result);
        scan.nextLine();
        System.out.println("Do you want to save results? Y/N");
        String choice = scan.nextLine();
        try {
            if (choice.equalsIgnoreCase("Y")) {
                save(result);
                System.out.println("Results successfully saved!");
            } else {
                System.out.println("Have a nice day!");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("Have a nice day!");
            System.exit(0);
        }

    }

    public void save(String results) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String path = Paths.get("").toAbsolutePath().toString();

        try (FileWriter saver = new FileWriter(path + "\\results.txt", true)) {
            System.out.println("Saving results to : " + path );
            saver.write(dtf.format(now) + " -> " + results + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
