import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameImpl implements Game {

    private static final Logger logger = LoggerFactory.getLogger("stdout");
    private static final Logger save = LoggerFactory.getLogger("logger");
    private static final Scanner scan = new Scanner(System.in);

    public void getPlayerName(Player player) {
        logger.info("Please enter your name: ");
        player.setName(scan.nextLine());
    }

    public void getGamesCount(Player player) {

        logger.info("Please enter number of games: ");
        try {
            player.setGamesCount(scan.nextInt());
        } catch (InputMismatchException e) {
            logger.info("Wrong input! Please restart the app and try again.");
        }

    }

    public void startRound(Player player, Computer computer) {

        int input;
        try {
            logger.info("""
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
                    logger.info("Ending game...");
                    endgame(player, computer);
                    System.exit(0);
                }
            }

            logger.info(player.getName() + " have chosen " + player.getPlayerHand());

            switch (new Random().nextInt(4 - 1) + 1) {
                case 1 -> computer.setComputerHand(Hand.ROCK);
                case 2 -> computer.setComputerHand(Hand.PAPER);
                case 3 -> computer.setComputerHand(Hand.SCISSORS);
            }

            logger.info("Computer have chosen " + computer.getComputerHand());

            findVictor(player, computer);

        } catch (InputMismatchException e) {
            logger.info("Wrong input! Please restart the app and try again.");
        }
    }

    public void findVictor(Player player, Computer computer) {

        if (player.getPlayerHand() == Hand.ROCK && computer.getComputerHand() == Hand.SCISSORS ||
                player.getPlayerHand() == Hand.SCISSORS && computer.getComputerHand() == Hand.PAPER ||
                player.getPlayerHand() == Hand.PAPER && computer.getComputerHand() == Hand.ROCK) {
            logger.info(player.getName() + " wins!");
            logger.info("-------------------------------------------------------");
            player.setPlayerWins(player.getPlayerWins() + 1);
            player.setTotalGamesPlayed(player.getTotalGamesPlayed() + 1);

        } else if (player.getPlayerHand() == computer.getComputerHand()) {
            logger.info("Draw! Try again!");
            startRound(player, computer);

        } else {
            logger.info("Computer wins!");
            logger.info("-------------------------------------------------------");
            computer.setComputerWins(computer.getComputerWins() + 1);
            player.setTotalGamesPlayed(player.getTotalGamesPlayed() + 1);
        }

    }


    public void endgame(Player player, Computer computer) {

        String result = "Player " + player.getName() + " won " + player.getPlayerWins()
                + " games, lost " + computer.getComputerWins() + " games. Total games played: "
                + player.getTotalGamesPlayed() + ".";
        logger.info(result);

        save.info(result);

    }

}
