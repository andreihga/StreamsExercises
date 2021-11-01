import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class IsPrime implements Predicate<Integer> {

    @Override
    public boolean test(Integer number) {
        IntPredicate intPredicate = index -> number % index == 0;
        return number > 1 && IntStream.range(2, number).noneMatch(intPredicate);
    }
}
