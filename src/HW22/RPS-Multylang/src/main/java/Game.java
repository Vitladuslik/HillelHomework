import java.util.ResourceBundle;

public interface Game {

    void getPlayerName(Player player, ResourceBundle resourceBundle);

    void getGamesCount(Player player, ResourceBundle resourceBundle);

    void startRound(Player player, Computer computer, ResourceBundle resourceBundle);

    void findVictor(Player player, Computer computer, ResourceBundle resourceBundle);

    void endgame(Player player, Computer computer, ResourceBundle resourceBundle);


}
