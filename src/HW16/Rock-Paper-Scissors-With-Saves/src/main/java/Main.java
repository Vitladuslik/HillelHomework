import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Player player = new Player();
        Computer computer = new Computer();
        GameImpl game = new GameImpl();

        game.getPlayerName(player);
        game.getGamesCount(player);

        System.out.println("Let's start!");

        for (int i = 0; i < player.getGamesCount(); i++) {
            game.startRound(player,computer);
        }

        game.endgame(player,computer);

    }

}
