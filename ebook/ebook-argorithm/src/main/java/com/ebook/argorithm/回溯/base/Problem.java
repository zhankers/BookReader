package com.ebook.argorithm.回溯.base;


/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-05-19 00:59
 */
public abstract class Problem {
    public int n;
    public Comparable[] x;
    public boolean flag;

    public abstract boolean isComplete();
    public abstract boolean printSolution();
    public abstract boolean isPartial();
    public abstract boolean explore();

}

