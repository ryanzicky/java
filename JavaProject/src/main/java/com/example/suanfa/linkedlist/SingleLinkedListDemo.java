package com.example.suanfa.linkedlist;

import java.util.Stack;

/**
 * @Author zhourui
 * @Date 2019/12/4 10:12
 */
public class SingleLinkedListDemo {

    public static void main(String[] args){
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode newHeroNode = new HeroNode(5, "卢俊义111", "玉麒麟111");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 无序添加
        /*singleLinkedList.addNode(hero1);
        singleLinkedList.addNode(hero2);
        singleLinkedList.addNode(hero3);
        singleLinkedList.addNode(hero4);*/

        // 有序添加
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(newHeroNode);
        System.out.println("添加后的链表");
        singleLinkedList.list();

        // 测试修改节点
        singleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表");
        singleLinkedList.list();

        singleLinkedList.delete(5);
        System.out.println("删除后的链表");
        singleLinkedList.list();

        // 获取单链表中有效节点个数
        System.out.println(getLength(singleLinkedList.getHead()));
        // 获取倒数第k个节点
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 2);
        System.out.println(res);

        // 单链表的反转
        /*System.out.println("单链表的反转");
        reversetList(singleLinkedList.getHead());
        singleLinkedList.list();*/

        // 逆序打印节点信息
        System.out.println("逆序打印节点信息");
        reversePrint(singleLinkedList.getHead());
    }

    // 逆序打印
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return; // 空链表,不打印
        }
        // 创建栈,顺序入栈
        Stack<HeroNode> stack = new Stack();
        HeroNode cur = head.next;
        // 将所有节点压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    // 将单链表反转
    public static void reversetList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }

        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        // 将head.next指向reverseHead.next，实现单链表反转
        head.next = reverseHead.next;
    }

    /**
     * 查找单链表中的倒数第k个节点
     *
     * 1.编写一个方法，接收head节点，同时接收一个index
     * 2.index表示是倒数第index个节点
     * 3.先把链表从头到尾遍历，得到链表的总的长度getlength
     * 4.得到size后，我们从链表的第一个开始遍历(size-index)个，就可以得到
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }


    /**
     * 获取单链表有效节点个数(不统计头结点)
     *
     * @param head 链表头结点
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}

class SingleLinkedList {
    // 先初始化一个头结点,头节点不要动,不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    // 返回头结点
    public HeroNode getHead() {
        return head;
    }

    // 添加节点到单向链表
    // 当不考虑顺序时
    // 找到当前链表的最后节点
    // 将最后节点的next，指向新的节点
    public void addNode(HeroNode heroNode) {
        HeroNode temp = head;
        // 遍历链表，找到最后节点
        while (true) {
            // 找到链表的最后节点
            if (temp.next == null) {
                break;
            }
            // 如果没有找到最后节点，将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后节点
        // 将最后节点的next指向新的节点
        temp.next = heroNode;
    }

    // 有序添加节点
    public void addByOrder(HeroNode heroNode) {
        // 通过辅助变量帮助找到添加的位置
        // 单链表，temp位于添加位置的前一个节点
        HeroNode temp = head;
        boolean flag = false; // 标识添加的编号是否存在,默认为false
        while (true) {
            if (temp.next == null) { // temp是最后的节点
                break;
            }
            if (temp.next.no > heroNode.no) { // 比较序号
                break;
            } else if (temp.next.no == heroNode.no) { // 编号存在
                flag = true; // 说明编号存在
                break;
            }
            temp = temp.next; // 后移，遍历当前链表
        }
        // 判断flag
        if (flag) { // 不能添加
            System.out.printf("准备插入的节点的编号%d已存在,不能添加\n", heroNode.no);
        } else {
            // 插入到链表中，temp后节点
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 修改节点的信息，根据节点编号修改，即no编号不能修改
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;// 是否找到该节点
        while (true) {
            if (temp == null) {
                break;// 已经遍历完链表
            }
            if (temp.no == newHeroNode.no) {// 找到节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // flag判断是否找到需要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("没有找到编号为%d的节点\n", newHeroNode.no);
        }
    }

    // 删除节点
    public void delete(int no) {
        HeroNode temp = this.head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到需要删除的节点编号%d\n", no);
        }
    }

    // 显示链表[遍历]
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点不能动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            // 判断是否到链表最后节点
            if (temp == null) {
                break;
            }
            // 输出节点信息
            System.out.println(temp);
            // 将temp后移
            temp = temp.next;
        }
    }
}

// 定义一个heroNode，每个heroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next; // 指向下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode [no = " + no + ", name = " + name + ", nickName = " + nickName + "]";
    }
}
