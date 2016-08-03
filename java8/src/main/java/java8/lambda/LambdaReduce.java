package java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * User: fh Date: 16/7/8 16:43
 */
public class LambdaReduce {
    public static void main(String[] args) {
        List<A> listA = new ArrayList<>();
        IntStream.range(0, 10).forEach((it) -> {
            listA.add(new A(it, it));
        });
        LongStream.of(1, 2, 3, 4).filter(e -> e > 2).peek(e -> System.out.println("Filtered value: " + e))
                .map(e -> e * e).peek(e -> System.out.println("Mapped value: " + e)).reduce(0, (left, right) -> {
                    long l = left + right;
                    System.out.println("    reduce     " + left + "+" + right + '=' + l);
                    return l;
                });
        // .sum();

        Integer reduce = listA.stream().map(A::getAge).reduce(0, (c, d) -> c + d);
        System.out.println("reduce = " + reduce);


        /**
         * lambda 使用并发情况下 identity 含义不同
         * java.util.stream.ReferencePipeline#reduce  -> java.util.stream.ReduceOps#makeRef
         * */
        Integer reduce1 = listA.stream().parallel().reduce(1,//1 初始值1的话,在并发情况下结果是不同的
                (id, a) -> {
            System.out.println("id+a = " + id + " + "+ a.getId() + " Tid: " + Thread.currentThread().getName() );
            return id + a.getId();
        }, (u, u2) -> {
            System.out.println("u + u2 = " + u +" + "+ u2 + " Tid: " + Thread.currentThread().getName() );
            return u + u2;
        });
        System.out.println("reduce1 = " + reduce1 + " Tid: " + Thread.currentThread().getName() );




        /**
         * java.util.stream.ReferencePipeline#reduce  -> java.util.stream.ReduceOps#makeRef
         * */
//        Integer reduce2 = listA.stream().parallel().map(A::getId)
//                .reduce(1,
//                         (u, u2) -> {
//                            System.out.println("u + u2 = " + u +" + "+ u2 + " Tid: " + Thread.currentThread().getName() );
//                            return u + u2;
//                        });
//        System.out.println("    reduce2 = " + reduce2 + " Tid: " + Thread.currentThread().getName() );


    }
}

class A {
    Integer id;
    Integer age;

    public A(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
