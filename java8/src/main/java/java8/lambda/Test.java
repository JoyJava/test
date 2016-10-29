package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * User: fh
 * Date: 14-8-6
 * Time: 14:07
 */
public class Test {
    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
//        Iterator it = list.iterator();
//        while (it.hasNext()) {
////            String s = (String) it.next();
////            if (s.equals("a")){
//                it.remove();
////            }
//
//        }
//
//        System.out.println(list);

        List<String> list = new ArrayList<String>();
        add(list,10);
        String s = list.get(0);

    }

    public static void add(List l , Object o){
        l.add(o);
    }
}
