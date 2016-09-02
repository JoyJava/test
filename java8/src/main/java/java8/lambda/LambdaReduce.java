package java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * User: fh Date: 16/7/8 16:43
 */
public class LambdaReduce {
    public static void main(String[] args) {
        List<Person> listPerson = new ArrayList<>();

        //初始化数据
        IntStream.range(0, 10).forEach((it) -> listPerson.add(new Person(it, it)));

//        long reduce2 = LongStream.of(1, 2, 3, 4, 5, 6, 7, 8)
//                .filter(e -> e > 2)
//                .peek(e -> System.out.println("Filtered value: " + e))
//                .map(e -> e * e)
//                .skip(2).limit(5)       //分页
//                .peek(e -> System.out.println("Mapped value: " + e))//.sum()
//                .reduce(0, (left, right) -> left + right);//效果同 sum()
//        System.out.println("reduce2 = " + reduce2);
//        System.out.println();



        int start = 1 ;

//        Integer reduce = listPerson.stream()
//                .reduce(0, (a,b) -> {
//                    System.out.println("a+b.getAge = " + a +" + "+ b.getAge());
//                   return a+b.getAge();
//                }, (c,d) -> {
//                    System.out.println("c+d = " + c  +" + "+ d);
//                    return c+d;
//                });
//        System.out.println("reduce = " + reduce +"\n");


        /**
         * lambda 使用并发情况下 identity 含义不同
         * java.util.stream.ReferencePipeline#reduce  -> java.util.stream.ReduceOps#makeRef
         * */
//        Integer reduce1 = listPerson
//                            .stream()
//                            .parallel()
//                            .reduce(start,//1 初始值1的话,在并发情况下结果是不同的
//                                    (sum, person) -> {
//                                        System.out.println("sum + getAge() = " + sum + " + "+ person.getAge() + " Tid: " + Thread.currentThread().getName() );
//                                        return sum += person.getId();
//                                    },
//                                    (u, u2) -> {
//                                        System.out.println("u + u2 = " + u +" + "+ u2 + " Tid: " + Thread.currentThread().getName() );
//                                        return u + u2;
//                                    });
//        System.out.println("reduce1 = " + reduce1 + " Tid: " + Thread.currentThread().getName() +"\n" );



        /**
         * lambda 使用并发情况下 identity 含义不同
         * java.util.stream.ReferencePipeline#reduce  -> java.util.stream.ReduceOps#makeRef
         * */
        Integer reduce3 = listPerson
                            .stream()
                            .reduce(start,//1 初始值1的话,在并发情况下结果是不同的
                                    (sum, person) -> {
                                        System.out.println("sum + getAge() = " + sum + " + "+ person.getAge() + " Tid: " + Thread.currentThread().getName() );
                                        return sum += person.getId();
                                    },
                                    (u, u2) -> {
                                        System.out.println("u + u2 = " + u +" + "+ u2 + " Tid: " + Thread.currentThread().getName() );
                                        return u + u2;
                                    });
        System.out.println("reduce3 = " + reduce3 + " Tid: " + Thread.currentThread().getName() +"\n" );




//        Integer reduce2 = listPerson.stream().parallel().map(Person::getId)
//                .reduce(1,
//                         (u, u2) -> {
//                            System.out.println("u + u2 = " + u +" + "+ u2 + " Tid: " + Thread.currentThread().getName() );
//                            return u + u2;
//                        });
//        System.out.println("    reduce2 = " + reduce2 + " Tid: " + Thread.currentThread().getName() );


    }
}

class Person {
    private Integer id;
    private Integer age;

    Person(int id, int age) {
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
