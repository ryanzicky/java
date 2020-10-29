package algorithm.test;

import algorithm.linear.Stack;

/**
 * @Author: zhourui
 * @Date: 2020-10-21 10:33
 **/
public class ReversePolishNotationTest {

    public static void main(String[] args) {
        // 中缀表达式 3 * (17 - 15) + 18 / 6 = 9
        String[] noataion = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = caculate(noataion);
        System.out.println("逆波兰表达式的结果: " + result);
    }

    public static int caculate(String[] notation) {
        // 1. 定义一个栈，用来存储操作数
        Stack<Integer> oprands = new Stack<>();
        // 2. 从左往右遍历逆波兰表达式，得到每一个元素
        for (int i = 0; i < notation.length; i++) {
            String curr = notation[i];
            // 3. 判断当前元素是运算符还是操作数
            Integer o1, o2, result;
            switch (curr) {
                case "+":
                    // 4. 运算符，从栈中弹出两个操作数，完成运算，运算完的结果再压入栈中
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o2 + o1;

                    oprands.push(result);
                    break;
                case "-":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o2 - o1;

                    oprands.push(result);
                    break;
                case "*":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o2 * o1;

                    oprands.push(result);
                    break;
                case "/":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o2 / o1;

                    oprands.push(result);
                    break;
                default:
                    // 5. 操作数，把该操作数放入到栈中
                    oprands.push(Integer.parseInt(curr));
                    break;
            }
        }



        // 6. 得到栈中最后一个元素，就是逆波兰表达式的结果

        return oprands.pop();
    }
}
