package com.ibook.algorithm;

/**
 * @Description: 给定两个链表 L1: 1 -> 5 -> 7 -> 9； L2: 9 -> 6 -> 7
 * 输出链表 L : 0 -> 2 -> 5 -> 0 -> 1
 * 因为 9751 + 769 = 10520
 * @Authr: yaunde
 * @Date: 2019-10-21 14:08
 */
public class Resume01 {

    public static void main(String[] args) {
        ListNode one = new ListNode(9);
        one.next = new ListNode(5);
        one.next.next = new ListNode(2);

        ListNode two = new ListNode(7);
        two.next = new ListNode(6);
        two.next.next = new ListNode(1);
        two.next.next.next = new ListNode(6);

        ListNode three = new ListNode(1);
        three.next = new ListNode(5);
        three.next.next = new ListNode(7);
        three.next.next.next = new ListNode(9);
        // three.next.next.next.next = new ListNode(6);

        ListNode four = new ListNode(9);
        four.next = new ListNode(6);
        four.next.next = new ListNode(7);


        ListNode listNode = addNumber(one, two);
        // ListNode listNode = addNumber(three, four);
        while (listNode != null) {
            System.out.print(listNode.value + " ");
            listNode = listNode.next;
        }

    }


    public static ListNode addNumber(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode((l1.value + l2.value) % 10);
        int flag = l1.value + l2.value >= 10 ? 1 : 0;

        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {
            int l1Value = l1 != null ? l1.value : 0;
            int l2Value = l2 != null ? l2.value : 0;

            ListNode tmp = listNode;
            while (tmp.next != null) {
                tmp = tmp.next;
            }

            tmp.next = new ListNode((l1Value + l2Value + flag) % 10);

            flag = l1Value + l2Value + flag >= 10 ? 1 : 0;

            if ((l2 == null || l2.next == null)) {
                if ((l1 == null || l1.next == null)) {
                    if (flag == 1) {
                        tmp.next.next = new ListNode(flag);
                    }
                    break;
                }
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

        }

        return listNode;

    }


    public static class ListNode {
        int value;

        ListNode next = null;

        public ListNode(int value) {
            this.value = value;
        }
    }
}

