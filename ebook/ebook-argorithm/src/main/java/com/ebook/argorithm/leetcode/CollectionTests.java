package com.ebook.argorithm.leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-05-12 23:07
 */
public class CollectionTests {

    public static void main(String[] args) {
        Set<Node> test1 = new TreeSet<Node>() {{
            add(new Node(1));
            add(new Node(7));
            add(new Node(3));
            add(new Node(6));
            add(new Node(4));
            add(new Node(5));
        }};

        Set<Node> test2 = new HashSet<Node>() {{
            add(new Node(1));
            add(new Node(7));
            add(new Node(3));
            add(new Node(6));
            add(new Node(4));
            add(new Node(5));
        }};
        System.out.println("=====TreeSet 输出顺序========");
        test1.forEach(v -> System.out.print(v + " "));
        System.out.println("\n=====HashSet 输出顺序========");
        test2.forEach(v -> System.out.print(v + " "));

        System.out.println(test2.add(new Node(1)));
    }

    static class Node implements Comparable<Node> {
        private Integer val;

        public Node(Integer val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(val, node.val);
        }
        @Override
        public int hashCode() {
            Random random = new Random();
            return Objects.hash(val);
        }

        @Override
        public int compareTo(Node o) {
            return this.val- o.val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

}
