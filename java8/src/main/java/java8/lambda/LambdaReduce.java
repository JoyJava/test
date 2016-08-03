package java8.lambda;

import java.util.stream.LongStream;

/**
 * User: fh Date: 16/7/8 16:43
 */
public class LambdaReduce {
    public static void main(String[] args) {
        LongStream.of(1, 2, 3, 4).filter(e -> e > 2)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(e -> e * e).peek(e -> System.out.println("Mapped value: " + e))
                .reduce(0, (left, right) -> {
                    long l = left + right;
                    System.out.println("    reduce     " + left +"+"+ right +'=' + l);
                    return l;
                });
        // .sum();



    }
}

class A{
    int id;
    int age;
}
