package jvm;


public class TestString {

    /**
     * @param args case2,5,6做concat的时候invokespecials调用了stringbuilder，生成的string id不一样，所以都是false,
     *             case1和3在做concatenation的时候直接进了operand stack，所以是true。
     *             intern()调的是pool里的值，所以是true
     *             <p>
     *             编译后 1 和 3 已经相同了.
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String a1 = "a1";
        String b1 = "a" + 1;
        System.out.print("1:  ");
        System.out.println(a1 == b1);

        String a2 = "ab";
        String bb2 = "b";
        String b2 = "a" + bb2;
        System.out.print("2:  ");
        System.out.println(a2 == b2);


        String a3 = "ab";
        final String bb3 = "b";
        String b3 = "a" + bb3;
        System.out.print("3:  ");
        System.out.println(a3 == b3);

        String a4 = "ab";
        final String bb4 = getBB();
        String b4 = "a" + bb4;
        System.out.print("4:  ");
        System.out.println(a4 == b4);

        String s5 = "a";
        String s51 = "b";
        String b5 = s5 + s51;
        System.out.print("5:  ");
        System.out.println(b5 == a5);
        System.out.println(b5.intern() == a5);

        String s6 = "a";
        String s61 = "b";
        String b6 = s6 + s61;
        System.out.print("6:  ");
        System.out.println(a6 == b6);
        System.out.println(a6 == b6.intern());
        System.out.println(a6.intern() == b6.intern());


    }

    private static String a5 = "ab";
    private static String a6 = new String("ab");

    public static String getBB() {
        return "b";
    }

}
