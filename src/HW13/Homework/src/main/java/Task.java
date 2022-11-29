import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;


public class Task {


    public double average(List<Integer> list) {
        if (Objects.nonNull(list)) {
            return list.stream()
                    .mapToInt((x) -> x)
                    .average().getAsDouble();
        } else return 0;
    }

    public List<Pair> upperCase(List<String> list) {
        if (Objects.nonNull(list)) {
            List<Pair> result = new ArrayList<>();
            list.forEach(s -> result.add(new Pair(s, s.toUpperCase())));

            return result;
        } else return null;
    }

    public boolean filter(List<String> list) {

        if (Objects.nonNull(list)) {
            Predicate<String> isLowerCase = s -> s.equals(s.toLowerCase());
            Predicate<String> isLength4 = s -> s.length() == 4;

            list.stream()
                    .filter(isLowerCase.and(isLength4))
                    .forEach(System.out::println);
            return true;
        } else return false;
    }

}
