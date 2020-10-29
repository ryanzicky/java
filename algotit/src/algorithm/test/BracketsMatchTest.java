package algorithm.test;

import algorithm.linear.Stack;

/**
 * 括号匹配问题
 *
 * @Author: zhourui
 * @Date: 2020-10-21 09:58
 **/
public class BracketsMatchTest {

    public static void main(String[] args) {
        String str = "(上海(长安)())";
        boolean match = isMatch(str);
        System.out.println(str + "中的括号是否匹配: " + match);
    }

    public static boolean isMatch(String str) {
        // 1. 创建栈对象，用来存储左括号
        Stack<String> chars = new Stack<>();
        // 2. 从坐往右遍历字符串
        for (int i = 0; i < str.length(); i++) {
            String currChar = str.charAt(i) + "";

            // 3. 判断当前字符是否为左括号,如果是，则把字符放入到栈中
            if (currChar.equals("(")) {
                chars.push(currChar);
            } else if (currChar.equals(")")) {
                // 4. 继续判断当前字符是否有右括号，如果是，则从栈中弹出一个左括号，并判断弹出的结果是否为null
                String pop = chars.pop();
                if (null == pop) {
                    return false;
                }
            }
        }

        // 5. 判断栈中是否还有剩余的左括号，如果有，则证明括号不匹配
        if (chars.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
