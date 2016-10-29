package java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
//        Unsafe.getUnsafe();
        Runnable a = () -> {
            System.out.println("asdasd");
        };
        a.run();

        List<String> list = Arrays.asList("1", "2", "2", "4", "3", "5", "8", "8", "7", "7", "120", "100");
//        list.stream().map(s -> new Integer(s)).forEach(System.out::println);
        list.stream().map(s ->
                //{ return new Integer(s);}  //功能同下,因为map方法中传入的Function<? super T, ? extends R>对象,所以可以使用return
                new Integer(s)
        ).filter(it ->
//                        if(it % 2 == 0) return true;//错误
                        //好假.必须返回TRUE,false才行,和groovy 闭包貌似有很多不同,
                        it >= 5 && it <= 100
        ).distinct().sorted((c1, c2) -> {
            return c1 < c2 ? 1 : -1;
        }).forEach(System.out::println);
//                .forEach(s -> {if (s > 1) System.out.println(s);});
        list.stream().map(it -> new Integer(it)).collect(Collectors.groupingBy(p -> p, Collectors.summingInt(p -> 1)))
                .forEach((k, v) -> System.out.println(k + "出现次数: " + v));

        //java8的Lambda表达式和groovy中闭包比较:第一感觉java中表达式比较混乱,比如stream中每个方法内部表现形式都不同,因为入参不同而在groovy中入参都是闭包.
        //在java8lambda表示中 方法入参必须是final类型的

        // Java的λ表达式只能用作赋值、传参、返回值等。

        //捕获的概念在于解决在λ表达式中我们可以使用哪些外部变量（即除了它自己的参数和内部定义的本地变量）的问题。
        //答案是：与内部类非常相似，但有不同点。不同点在于内部类总是持有一个其外部类对象的引用。而λ表达式呢，除非在它内部用到了其外部类（包围类）对象的方法或者成员，否则它就不持有这个对象的引用。

//        任何一个λ表达式都可以代表某个函数接口的唯一方法的匿名描述符。我们也可以使用某个类的某个具体方法来代表这个描述符，叫做方法引用。例如：
//
//        Integer::parseInt //静态方法引用
//        System.out::print //实例方法引用
//        Person::new       //构造器引用
//
//        下面是一组例子，教你使用方法引用代替λ表达式：
//
//        //c1 与 c2 是一样的（静态方法引用）
//        Comparator<Integer> c2 = (x, y) -> Integer.compare(x, y);
//        Comparator<Integer> c1 = Integer::compare;
//
//        //下面两句是一样的（实例方法引用1）
//        persons.forEach(e -> System.out.println(e));
//        persons.forEach(System.out::println);
//
//        //下面两句是一样的（实例方法引用2）
//        persons.forEach(person -> person.eat());
//        persons.forEach(Person::eat);
//
//        //下面两句是一样的（构造器引用）
//        strList.stream().map(s -> new Integer(s));
//        strList.stream().map(Integer::new);
//
//        使用方法引用，你的程序会变得更短些。现在distinctPrimarySum方法可以改写如下：
//
//        public void distinctPrimarySum(String... numbers) {
//            List<String> l = Arrays.asList(numbers);
//            int sum = l.stream().map(Integer::new).filter(Primes::isPrime).distinct().sum();
//            System.out.println("distinctPrimarySum result is: " + sum);
//        }
//
//        还有一些其它的方法引用:
//
//        super::toString //引用某个对象的父类方法
//        String[]::new //引用一个数组的构造器

    }


}
