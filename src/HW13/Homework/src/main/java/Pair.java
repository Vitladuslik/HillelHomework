import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor


public class Pair {

    private String s1;
    private String s2;

    @Override
    public String toString() {
        return "{" + s1 + ", " + s2 + '}';
    }
}
