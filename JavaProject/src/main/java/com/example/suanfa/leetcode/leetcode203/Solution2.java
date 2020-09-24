package com.example.suanfa.leetcode.leetcode203;

/**
 * 删除链表中给定值的元素
 *
 * @Author zhourui
 * @Date 2019/12/2 9:59
 */
class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        // 创建虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);

        System.out.println(head);

        ListNode res = (new Solution2()).removeElements(head, 6);
        System.out.println(res);
    }
}
