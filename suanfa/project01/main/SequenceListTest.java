package main;

import linear.SequenceList;

/**
 * @Author zhourui
 * @Date 2020/8/14 15:58
 */
public class SequenceListTest {

    public static void main(String[] args){
        SequenceList<String> s1 = new SequenceList<>(10);

        s1.insert("姚明");
        s1.insert("科比");
        s1.insert("麦蒂");
        s1.insert(1,"詹姆斯");

        for (String s : s1) {
            System.out.println(s);
        }

        System.out.println("=============================");

        System.out.println(s1.get(1));
        System.out.println(s1.remove(0));

        s1.clear();
        System.out.println(s1.length());
    }
}
