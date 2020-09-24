package com.example.suanfa.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author zhourui
 * @Date 2019/12/10 10:33
 */
public class PolandNotation {

    public static void main(String[] args){

        // 中缀表达式转list
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的list = " + infixExpressionList);
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的list = " + suffixExpressionList);

        // 后缀表达式计算结果
        System.out.println("calculate(suffixExpressionList) = " + calculate(suffixExpressionList));
        // 逆波兰表达式(后缀表达式)
        // (3+4)*5-6 => 3 4 + 5 * 6 -
//        String suffixExpression = "3 4 + 5 * 6 - ";
        // 中缀表达式
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        // 1.现将3 4 + 5 * 6 - 放入ArrayList中
        // 2.将ArrayList配合栈计算

        List<String> rpnList = getLastString(suffixExpression);
        System.out.println("rpnList = " + rpnList);
        int calculate = calculate(rpnList);
        System.out.println("calculate = " + calculate);
    }

    public static List<String> parseSuffixExpressionList(List<String> ls) {
        Stack<String> s1 = new Stack<>(); // 符号栈
        List<String> s2 = new ArrayList<>(); // 存储中间结果的栈
        for (String item : ls) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop(); //  将"("弹出s1栈,消除小括号
            } else {
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }

        // 将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    // 中缀表达式转list
    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<>();
        int i = 0;
        String str;
        char c;
        do {
            // 如果c是非数字,添加到ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else { // 考虑多位数
                str = ""; // 现将str置空
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

    public static List<String> getLastString(String suffixExpression) {
        return Arrays.asList(suffixExpression.split(" "));
    }

    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<String>();
        ls.forEach(item -> {
            // 使用正则表达式取出数
            if (item.matches("\\d+")) { // 匹配多位数
                // 入栈
                stack.push(item);
            } else {
                // pop出两个数执行计算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());

                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算报错");
                }
                stack.push(String.valueOf(res));
            }
        });
        return Integer.parseInt(stack.pop());
    }
}

// 返回一个运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("运算符错误");
                break;
        }
        return result;
    }
}