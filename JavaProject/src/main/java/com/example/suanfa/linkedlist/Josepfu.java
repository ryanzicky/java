package com.example.suanfa.linkedlist;


/**
 * @Author zhourui
 * @Date 2019/12/6 15:05
 */
public class Josepfu {

    public static void main(String[] args){
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);

        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}

// 创建环形单向链表
class CircleSingleLinkedList {
    // 创建一个first节点,当前没有编号
    private Boy first = null;

    // 添加Boy节点,构建成一个环形链表
    public void addBoy(int nums) {
        // nums做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不对");
            return;
        }
        Boy curBoy = null; // 帮助构建环形链表
        // 使用for循环来创建环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号,创建节点
            Boy boy = new Boy(i);
            // 如果是第一个节点
            if (i == 1) {
                first = boy;
                first.setNext(first); // 构成环形
                curBoy = first; // 让curBoy指向第一个节点
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    // 遍历当前环形链表
    public void showBoy() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("没有节点");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("节点编号%d \n", curBoy.getNo());
            if (curBoy.getNext() == first) { // 遍历完毕
                break;
            }
            curBoy = curBoy.getNext(); // curBoy后移
        }
    }

    // 根据用户的输入，计算节点出圈的顺序
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入错误");
            return;
        }

        Boy helper = first;

        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if (helper == first) { // 只有一个节点
                break;
            }
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 此时first节点就是要出圈的节点
            System.out.printf("节点%d出圈\n", first.getNo());
            first = first.getNext(); // 节点出圈
            helper.setNext(first);
        }
        System.out.printf("剩下的节点 %d \n", first.getNo());
    }
}

class Boy {
    private int no; // 编号
    private Boy next; // 指向下一个节点,默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
