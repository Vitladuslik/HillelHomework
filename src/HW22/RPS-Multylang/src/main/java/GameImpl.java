import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GameImpl implements Game {

    private static final Logger logger = LoggerFactory.getLogger("stdout");
    private static final Logger save = LoggerFactory.getLogger("logger");
    private static final Scanner scan = new Scanner(System.in);

    public void getPlayerName(Player player, ResourceBundle resourceBundle) {
        logger.info(resourceBundle.getString("enter_name"));
        player.setName(scan.nextLine());
    }

    public void getGamesCount(Player player, ResourceBundle resourceBundle) {

        logger.info(resourceBundle.getString("games_count"));
        try {
            player.setGamesCount(scan.nextInt());
        } catch (InputMismatchException e) {
            logger.info(resourceBundle.getString("games_count_error"));
        }

    }

    public void startRound(Player player, Computer computer, ResourceBundle resourceBundle) {

        int input;
        try {
            logger.info(resourceBundle.getString("hand_move"));
            input = scan.nextInt();

            switch (input) {
                case 1 -> player.setPlayerHand(Hand.ROCK);
                case 2 -> player.setPlayerHand(Hand.PAPER);
                case 3 -> player.setPlayerHand(Hand.SCISSORS);
                default -> {
                    logger.info(resourceBundle.getString("exit_game"));
                    endgame(player, computer, resourceBundle);
                    System.exit(0);
                }
            }

            logger.info(player.getName() + resourceBundle.getString("choice") + player.getPlayerHand());

            switch (new Random().nextInt(4 - 1) + 1) {
                case 1 -> computer.setComputerHand(Hand.ROCK);
                case 2 -> computer.setComputerHand(Hand.PAPER);
                case 3 -> computer.setComputerHand(Hand.SCISSORS);
            }

            logger.info(resourceBundle.getString("computer_choice") + computer.getComputerHand());

            findVictor(player, computer, resourceBundle);

        } catch (InputMismatchException e) {
            logger.info(resourceBundle.getString("games_count_error"));
        }
    }

    public void findVictor(Player player, Computer computer, ResourceBundle resourceBundle) {

        if (player.getPlayerHand() == Hand.ROCK && computer.getComputerHand() == Hand.SCISSORS ||
                player.getPlayerHand() == Hand.SCISSORS && computer.getComputerHand() == Hand.PAPER ||
                player.getPlayerHand() == Hand.PAPER && computer.getComputerHand() == Hand.ROCK) {
            logger.info(player.getName() + resourceBundle.getString("player_wins"));
            logger.info("-------------------------------------------------------");
            player.setPlayerWins(player.getPlayerWins() + 1);
            player.setTotalGamesPlayed(player.getTotalGamesPlayed() + 1);

        } else if (player.getPlayerHand() == computer.getComputerHand()) {
            logger.info(resourceBundle.getString("draw"));
            startRound(player, computer, resourceBundle);

        } else {
            logger.info(resourceBundle.getString("computer_wins"));
            logger.info("-------------------------------------------------------");
            computer.setComputerWins(computer.getComputerWins() + 1);
            player.setTotalGamesPlayed(player.getTotalGamesPlayed() + 1);
        }

    }


    public void endgame(Player player, Computer computer, ResourceBundle resourceBundle) {

        String result = resourceBundle.getString("player") + player.getName() + resourceBundle.getString("won")
                + player.getPlayerWins() + resourceBundle.getString("games") + computer.getComputerWins()
                + resourceBundle.getString("games_lost") + player.getTotalGamesPlayed() + ".";
        logger.info(result);

        save.info(result);

    }

}
