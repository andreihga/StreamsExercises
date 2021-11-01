import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        printNumbersByCriteria(integerList, number -> {
            IntPredicate intPredicate = index -> number % index == 0;
            return number > 1 && IntStream.range(2, number).noneMatch(intPredicate);
        });
    }

    public static void printNumbersByCriteria(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream().filter(predicate).forEach(System.out::println);
    }
}
