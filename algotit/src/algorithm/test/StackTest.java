package algorithm.test;

import algorithm.linear.Stack;

/**
 * @Author: zhourui
 * @Date: 2020-10-20 17:57
 **/
public class StackTest {

    public static void main(String[] args) {
        // 创建栈对象
        Stack<String> stack = new Stack<>();
        // 测试压栈
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        for (String item : stack) {
            System.out.println(item);
        }
        System.out.println("====================================");
        // 测试出栈

        String result = stack.pop();
        System.out.println("弹出的元素是: " + result);
        System.out.println("剩余的元素个数: " + stack.size());
    }
}
