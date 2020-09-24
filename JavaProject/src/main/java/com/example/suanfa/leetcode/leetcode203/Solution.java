package com.example.suanfa.leetcode.leetcode203;

/**
 * 删除链表中给定值的元素
 *
 * @Author zhourui
 * @Date 2019/12/2 9:59
 */
class Solution {

    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }
}
