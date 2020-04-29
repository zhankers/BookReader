package com.ibook.algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-04-29 23:31
 */
public class BinaryTreeDemo {
    public static void pre(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.print(treeNode.val + " ");
        mid(treeNode.left);
        mid(treeNode.right);
    }

    public static void mid(TreeNode treeNode) {
        if (treeNode == null) return;
        mid(treeNode.left);
        System.out.print(treeNode.val + " ");
        mid(treeNode.right);
    }

    public static void pos(TreeNode treeNode) {
        if (treeNode == null) return;
        mid(treeNode.left);
        mid(treeNode.right);
        System.out.print(treeNode.val + " ");
    }

    public static void preByCycle(TreeNode treeNode) {
        if (treeNode == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.val + " ");
            if (pop.right != null)
                stack.push(pop.right);
            if (pop.left != null)
                stack.push(pop.left);
        }
    }

    public static void midByCycle(TreeNode treeNode) {
        if (treeNode == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(treeNode);
        TreeNode p = treeNode;
        while (!stack.isEmpty()) {
            if (p.left != null) {
                stack.push(p.left);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.print(pop.val + " ");
                if (pop.right != null) {
                    stack.push(pop.right);
                    p = pop.right;
                }
            }
        }
    }

    /**
     * 后序  左右根
     * == 根右左 再 倒序
     */
    public static void posByCycle(TreeNode treeNode) {
        if (treeNode == null) return;
        List<Object> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }

        Collections.reverse(list);
        System.out.println(list);
    }

    public static void bfs(TreeNode treeNode) {
        if (treeNode == null) return;
        List<Object> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.val + " ");
            if (poll.left != null) {
                queue.offer(poll.left);
            }

            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }

}

class TreeNode<T> {
    T val;
    TreeNode<T> left, right;

    TreeNode(T value) {
        this.val = value;
    }
}
