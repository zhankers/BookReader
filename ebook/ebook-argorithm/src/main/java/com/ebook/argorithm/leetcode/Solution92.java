package com.ebook.argorithm.leetcode;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode newHead = head, p, q, pr, mPreNode;

        for (int position = 1; head!=null; position++) {
            if (m-1 == position) {
                newHead = head;
            }

            if (n+1 == position) {
                mPreNode = head;
            }

            if (position >= m && position <= n) {
                head = head.next;
                newHead.next.next = newHead;
                newHead = newHead.next;
                continue;
            }



            newHead = head;
            head = head.next;
        }


//        while (head != null) {
//
//        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode = new Solution92().reverseBetween(listNode1, 2, 4);

        System.out.println(ListNode.print(listNode));

    }
}
