import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Pair {

    private String s1;
    private String s2;

    @Override
    public String toString() {
        return "{" + s1 + ", " + s2 + '}';
    }
}
