package java基础;

/**
 * User: fh
 * Date: 2017/2/8 下午12:10
 */
public class 抽象类反射 extends ATest{
    public static void main(String[] args) {
        抽象类反射 aa = new 抽象类反射();
        aa.a();
    }

}


abstract class ATest {
    private String name;
    private int age;

    public void a(){
        String simpleName = this.getClass().getSimpleName();
        System.out.println("simpleName = " + simpleName);
    }
}
