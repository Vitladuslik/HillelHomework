

public interface Game {

    void getPlayerName(Player player);

    void getGamesCount(Player player);

    void startRound(Player player, Computer computer);

    void findVictor(Player player, Computer computer);

    void endgame(Player player, Computer computer);


}
