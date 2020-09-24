package com.example.suanfa.stack;

/**
 * @Author zhourui
 * @Date 2019/12/9 18:28
 */
public class Calculator {

    public static void main(String[] args){
        String expression = "70+2*6-4";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;

        char ch = ' ';// 将每次扫描得到的char保存到ch
        String keepNum = "";
        // 开始while循环的扫描expression
        while (true) {
            // 依次得到每个字符
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) { // 如果是运算符
                // 判断当前符号栈是否为空
                if (!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        // 运算结果入数栈
                        numStack.push(res);
                        // 当前操作符入符号栈
                        operStack.push(ch);
                    } else {
                        // 如果当前的操作符优先级大于栈中的操作符,直接入符号栈
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else { // 如果是数栈,直接入数栈
//                numStack.push(ch - 48);
                keepNum += ch;

                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if(operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        while (true) {
            // 如果符号栈为空,则计算到最后结果,数栈中只有一个数字(结果)
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        int res2 = numStack.pop();
        System.out.printf("表达式 %s = %d", expression, res2);
    }
}

class ArrayStack2 {
    private int maxSize; // 栈的大小
    private int[] stack; // 数组，存放数据
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 返回栈顶的值
    public int peek() {
        return stack[top];
    }

    public boolean isFulle() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFulle()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 遍历栈,需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    // 返回运算符的优先级，数字越大  优先级越搞
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    // 是否运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    public int cal(int num1, int num2, int opr) {
        int res = 0;
        switch (opr) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
