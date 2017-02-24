package java基础;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * User: fh
 * Date: 16/11/23 上午11:16
 */
public class List传递问题 {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList();

        list.add("11");
        list.add("12");
        list.add("13");

        System.out.println("1 ~~~~~" + list);

        listTest(list);
        System.out.println("2 ~~~~~" + list);

        System.out.print(" 2.2  ~~~~~ "  );
        list.stream().sorted((o1, o2) -> o1.compareTo(o2)).forEach(s -> System.out.print(s + ", ")); //排序不影响原始结果
        System.out.println();

        list.sort((o1, o2) -> o1.compareTo(o2 ));
        System.out.println("3 ~~~~~" + list);


        String s = list.get(list.size() - 4 + 1 );
        System.out.println("s = " + s);
    }

    public static void listTest(List<String> list) {
        for (int i = 10; i > 0; i--) {
            list.add(i + "");

        }
//        System.out.println(list);

    }
}
