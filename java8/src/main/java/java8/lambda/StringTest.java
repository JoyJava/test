package java8.lambda;

/**
 * User: fh
 * Date: 14-8-7
 * Time: 17:53
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "asd";
        String s2 = "asd";
        System.out.println(s1 == s2);

        String s3 = new String("asd").intern();
        String s4 = new String("asd").intern();
        System.out.println(s3 == s4);
        System.out.println(s3.intern() == s4.intern());


    }
}
