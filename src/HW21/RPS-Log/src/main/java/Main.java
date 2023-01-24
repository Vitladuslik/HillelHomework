
public class Main {


    public static void main(String[] args) {

        Player player = new Player();
        Computer computer = new Computer();
        GameImpl game = new GameImpl();

        game.getPlayerName(player);
        game.getGamesCount(player);

        for (int i = 0; i < player.getGamesCount(); i++) {
            game.startRound(player, computer);
        }

        game.endgame(player, computer);

    }

}
