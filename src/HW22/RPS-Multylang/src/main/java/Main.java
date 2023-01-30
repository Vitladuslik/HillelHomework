import java.util.Locale;
import java.util.ResourceBundle;

public class Main {


    public static void main(String[] args) {

        Locale locale = Locale.getDefault();
        if (args.length != 0) {
            if(args[0].equalsIgnoreCase("en") | args[0].equalsIgnoreCase("de")) {
                locale = new Locale(args[0]);
            }
        }

        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", locale);

        Player player = new Player();
        Computer computer = new Computer();
        GameImpl game = new GameImpl();

        game.getPlayerName(player, resourceBundle);
        game.getGamesCount(player, resourceBundle);

        for (int i = 0; i < player.getGamesCount(); i++) {
            game.startRound(player, computer, resourceBundle);
        }

        game.endgame(player, computer, resourceBundle);

    }

}
