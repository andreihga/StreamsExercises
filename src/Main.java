import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        int sumPrimeNumbers = printNumbersByCriteria(integerList,number ->
             number >= 2 && IntStream.range(2,number).noneMatch(i -> number % i == 0) // prime number
        );

        System.out.println(sumPrimeNumbers);

    }

    public static int printNumbersByCriteria(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().filter(predicate).mapToInt(i -> i).sum();
    }

}
