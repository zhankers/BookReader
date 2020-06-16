package com.ebook.argorithm.leetcode;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int value;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { value = x; }
}

public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(treeNode);
        TreeNode tmpNode = treeNode;
        while(!stack.isEmpty()) {
            if(tmpNode.left != null){
                tmpNode = tmpNode.left;
                stack.push(tmpNode.left);
            } else {
                TreeNode topNode = stack.pop();
                if (topNode != null) {
                    res.add(topNode.value);
                }
                res.add((Integer) topNode.value);
                if (topNode.right != null) {
                    tmpNode = topNode.right;
                    stack.push(topNode.right);
                }
            }
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);



    }

}