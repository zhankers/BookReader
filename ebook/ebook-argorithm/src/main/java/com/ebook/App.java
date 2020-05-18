package com.ebook;

import com.ebook.argorithm.datastruct.TreeNode;

import java.util.Stack;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode treeNode = sortedArrayToBST(numbers);

        /**
         * 二叉树遍历
         */
        preOrder(treeNode);

    }


    public static <E> TreeNode sortedArrayToBST(E[] arr) {
        if (null == arr || arr.length == 0) {
            return null;
        }

        return sortedArrayToBST(arr, 0, arr.length);
    }

    private static <E> TreeNode sortedArrayToBST(E[] arr, int start, int end) {
        if (start >= end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode<E> root = new TreeNode<>(arr[mid]);
        root.right = sortedArrayToBST(arr, start, mid);
        root.left = sortedArrayToBST(arr, mid + 1, end);
        return root;
    }

    /**
     * 先序遍历
     *
     * @param treeNode
     */
    public static void preOrder(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.value + " ");
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }
    }

    public static void preOrderRe(TreeNode biTree) {
        //递归实现
        System.out.println(biTree.value);

        TreeNode leftTree = biTree.left;
        if (leftTree != null) {
            preOrderRe(leftTree);
        }
        TreeNode rightTree = biTree.right;
        if (rightTree != null) {
            preOrderRe(rightTree);
        }
    }

    public static void preOrder2(TreeNode biTree) {
        //非递归实现
        Stack<TreeNode> stack = new Stack<>();

        while (biTree != null || !stack.isEmpty()) {

            while (biTree != null) {
                System.out.println(biTree.value);
                stack.push(biTree);
                biTree = biTree.left;
            }

            if (!stack.isEmpty()) {
                biTree = stack.pop();
                biTree = biTree.right;
            }
        }
    }

}
