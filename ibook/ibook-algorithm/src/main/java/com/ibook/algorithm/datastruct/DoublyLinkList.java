package com.ibook.algorithm.datastruct;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2019-10-23 13:14
 */
public class DoublyLinkList<E> {

    Node<E> first;
    Node<E> last;

    /**
     * 节点
     */
    public static class Node<E> {
        E value;
        Node<E> pre;
        /**
         * 指向下一个节点
         */
        Node<E> next;

        public Node(E value, Node pre, Node next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }

        public Node(E value) {
            this.value = value;
        }
    }
}


