package com.ebook.argorithm.回溯.base;


/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-05-19 00:59
 */
public abstract class Problem {
    // 解向量长度
    public int n;
    // 解向量
    public Comparable[] x;

    public boolean flag;


    // 该解是否合法
    public abstract boolean isComplete(int k);

    public abstract void printSolution(int k);

    // 是否是部分解，否则继续递归
    public abstract boolean isPartial(int k);
    // 回溯主体
    public abstract void explore(int k);

}

