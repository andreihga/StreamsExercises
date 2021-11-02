import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        long start = System.currentTimeMillis();
        System.out.println(squareOfMaximumOddNumberFromRange(integerList));
        long stop = System.currentTimeMillis();
        System.out.println(stop-start);

        Thread.sleep(1000);

        long startStreams = System.currentTimeMillis();
        System.out.println(squareOfMaximumOddNumberFromRangeWithStreams(integerList));
        long stopStreams = System.currentTimeMillis();
        System.out.println(stopStreams -startStreams);

    }

    /*Without streams*/

    static int squareOfMaximumOddNumberFromRange(List<Integer> integerList) {
        // range is (3,11)

        int maxOddNumber = 0;

        for (Integer i : integerList) {
            if (i % 2 != 0 && i > 3 && i < 11 && i > maxOddNumber) {
                maxOddNumber = i;
            }
        }
        return maxOddNumber * maxOddNumber;
    }

    /*With streams*/

    static int squareOfMaximumOddNumberFromRangeWithStreams(List<Integer> integerList) {
        return integerList.stream().filter(i -> i % 2 != 0)
                .filter(i -> i > 3)
                .filter(i -> i < 11)
                .max(Comparator.naturalOrder())
                .map(i -> i * i)
                .get();
    }

}
