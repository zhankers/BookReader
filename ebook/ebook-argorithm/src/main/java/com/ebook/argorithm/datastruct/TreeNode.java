package com.ebook.argorithm.datastruct;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2019-10-26 01:45
 */
public class TreeNode<E> {
    public TreeNode left;
    public TreeNode right;
    public E value;

    public TreeNode(E value) {
        this.value = value;
    }
}
