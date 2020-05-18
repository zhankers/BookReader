package com.ebook.argorithm.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static String print(ListNode head) {
        StringBuilder sb = new StringBuilder("ListNode:{");
        for (ListNode temp = head; temp != null; ) {
            temp = temp.next;
            sb.append(temp.val).append(",");
        }
        sb.delete(sb.length() -1, sb.length()).append("}");
        return sb.toString();
    }
}