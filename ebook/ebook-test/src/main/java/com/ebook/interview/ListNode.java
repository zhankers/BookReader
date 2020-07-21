package com.ebook.interview;

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode pre = null, post = null;
        int i = 1;
        for (ListNode temp = head; temp != null; i++, temp = temp.next){
            pre = m - 1 == i ? temp : pre;
            post = n + 1 == i ? temp : post;
        }

        if (head == null || m >= n || pre == null || post == null) {
            return head;
        }


        ListNode newHead = pre.next;
        ListNode temp = newHead.next;
        newHead.next = post;
        while (temp != post) {
            ListNode tempNext = temp.next;
            temp.next = newHead;
            newHead = temp;
            temp = tempNext;
        }

        pre.next = newHead;

        return head;


    }
}