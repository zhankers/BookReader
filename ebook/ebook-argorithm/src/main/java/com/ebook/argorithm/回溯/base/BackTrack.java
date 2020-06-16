package com.ebook.argorithm.回溯.base;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-06-06 15:32
 */
public class BackTrack {

    public static void backtrack(Problem p) {
        p.explore(0);
        if (!p.flag)
            System.out.println("no solution");
    }
}
