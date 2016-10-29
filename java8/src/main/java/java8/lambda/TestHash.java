package java8.lambda;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * User: fh
 * Date: 15-10-26 18:19
 */
public class TestHash {
    public static void main(String[] args) {
        Set<String > set = new HashSet<>(10);

        IntStream.range(1,20).forEach((it) -> {
            set.add(it+"");
        });

        set.stream().forEach((it) -> {
            System.out.println(it);
        });

    }
}
