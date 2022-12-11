import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameImplTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }


    @Test
    void findVictor() {

        Player player = new Player();
        player.setName("Test");
        Computer computer = new Computer();
        GameImpl game = new GameImpl();

        assertNotNull(player);
        assertNotNull(player.getName());
        assertNotNull(computer);
        assertNotNull(game);

        player.setPlayerHand(Hand.PAPER);
        computer.setComputerHand(Hand.ROCK);

        game.findVictor(player,computer);

        assertEquals(1, player.getPlayerWins());
        assertEquals(1, player.getTotalGamesPlayed());

        player.setPlayerHand(Hand.SCISSORS);

        game.findVictor(player,computer);

        assertEquals(1, computer.getComputerWins());
        assertEquals(2, player.getTotalGamesPlayed());
    }

    @Test
    void endgame() {

        //Знаю, що краще так не робити. Залишив лише для навчальних цілей (тестування можливостей)

        Player player = new Player();
        Computer computer = new Computer();
        GameImpl game = new GameImpl();

        player.setName("Alex");
        player.setPlayerWins(3);
        player.setTotalGamesPlayed(5);
        computer.setComputerWins(2);

        game.endgame(player,computer);

        assertEquals("Player Alex won 3 games, lost 2 games. Total games played: 5", outContent.toString());
    }
}