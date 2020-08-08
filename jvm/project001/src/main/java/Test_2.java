/**
 * A Static Block
 * A str
 *
 * @Author zhourui
 * @Date 2020/8/5 13:55
 */
public class Test_2 {

    public static void main(String[] args){
        System.out.println(Test_2_B.str);
    }
}

class Test_2_A {

    public static String str = "A str";

    static {
        System.out.println("A Static Block");
    }
}

class Test_2_B extends Test_2_A {
    static {
        str += "#11";

        System.out.println("B Static Block.");
    }
}
