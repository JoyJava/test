package java8.lambda;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.DoubleStream;

/**
 * User: fh
 * Date: 16/11/22 下午4:10
 */
public class LIstTest {
    public static void main(String[] args) {
        List<Double> list = Lists.newArrayList();

        DoubleStream.of (1.1,3,5,7.1,2.2,3.3,1, 31).forEach(list::add);

//        list = Lists.reverse(list);
//        list.forEach(System.out::println);
//        System.out.println();

        double asDouble = list.stream().parallel()
                .sorted(Double::compareTo)
                .skip(list.size() - 5)
                .peek(integer -> System.out.println( integer + " + " ))
                .mapToDouble(value -> value)
//                .peek(integer -> System.out.println(integer + " ------- "))
                .average()
                .getAsDouble();

        System.out.println(asDouble);
        System.out.println();
        list.forEach(System.out::println);

    }
}
