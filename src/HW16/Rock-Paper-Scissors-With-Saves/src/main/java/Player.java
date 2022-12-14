import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Player {

    private String name;
    private int gamesCount;
    private int playerWins;
    private int totalGamesPlayed;
    private Hand playerHand;

}
