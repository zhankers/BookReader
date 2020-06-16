package com.ebook.argorithm.回溯.lettcode;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }

        inorderTraversal(treeNode.left, res);
        res.add(treeNode.val);
        inorderTraversal(treeNode.right, res);

    }

}