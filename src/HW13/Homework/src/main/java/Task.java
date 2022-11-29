import java.util.List;
import java.util.function.Predicate;


public class Task {

    public static void main(String[] args) {

        Task solution = new Task();

        List<Integer> testIntegers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> testString = List.of("Black", "book", "cLever", "dEEp", "eye");

        solution.average(testIntegers);
        solution.filter(testString);


    }

    private void average(List<Integer> list) {
        list.stream()
                .mapToInt((x) -> x)
                .average()
                .ifPresent(avg -> System.out.println("Average is " + avg));
    }

    private void uppercase(List <String> list) {

        List<String> uppercase = list.stream()
                .map(String::toUpperCase)
                .toList();


    }

    private void filter(List<String> list) {
        Predicate<String> isLowerCase = s -> s.equals(s.toLowerCase());
        Predicate<String> isLength4 = s -> s.length() == 4;

        list.stream()
                .filter(isLowerCase.and(isLength4))
                .forEach(System.out::println);
    }

}
