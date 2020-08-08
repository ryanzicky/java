/**
 * @Author zhourui
 * @Date 2020/8/5 13:41
 */
public class Test_1 {

    public static void main(String[] args){

        Test_1_A instance = Test_1_A.getInstance();

        System.out.println(Test_1_A.val1);
        System.out.println(Test_1_A.val2);
    }
}

class Test_1_A {
    public static int val1;
    public static Test_1_A instance = new Test_1_A();

    Test_1_A() {
        val1++;
        val2++;
    }

    public static int val2 = 1;

    public static Test_1_A getInstance() {
        return instance;
    }
}
