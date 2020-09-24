package com.example.suanfa.leetcode.leetcode203;

/**
 * @Author zhourui
 * @Date 2019/12/2 14:33
 */
public class Solution3 {

    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthStr = generateDepthStr(depth);
        System.out.print(depthStr);
        System.out.println("Call: remove " + val + " in " + head);
        if (head == null) {
            System.out.print(depthStr);
            System.out.println("Return: " + head);
            return null;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthStr);
        System.out.println("After remove " + val + ": " + res);

        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }
        System.out.print(depthStr);
        System.out.println("Return: " + ret);
        return ret;
    }

    private String generateDepthStr(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);

        System.out.println(head);

        ListNode res = (new Solution3()).removeElements(head, 6, 0);
        System.out.println(res);
    }
}
