package com.example.suanfa.linkedlist;

/**
 * @Author zhourui
 * @Date 2019/12/5 16:57
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args){
        System.out.println("双向链表测试");
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        // 新增
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addNode(hero1);
        doubleLinkedList.addNode(hero2);
        doubleLinkedList.addNode(hero3);
        doubleLinkedList.addNode(hero4);
        doubleLinkedList.list();

        // 修改
        HeroNode2 hero5 = new HeroNode2(4, "林冲111", "豹子头111");
        doubleLinkedList.update(hero5);
        System.out.println("修改后的链表");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.delete(3);
        System.out.println("删除后的链表");
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public DoubleLinkedList() {

    }

    // 新增
    public void addNode(HeroNode2 heroNode) {
        HeroNode2 temp = head;
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
        // 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 删除
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空,无法删除");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp.next == null) { // 已经找到链表最后节点
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("没有找到需要删除的节点编号%d\n", no);
        }
    }

    // 修改
    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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

    // 查看
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点不能动，因此需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
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

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next; // 指向下一个节点，默认null
    public HeroNode2 pre; // 指向前一个节点，默认null

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2 [no = " + no + ", name = " + name + ", nickName = " + nickName + "]";
    }
}
