package com.ibook.algorithm;

import org.springframework.core.io.ClassPathResource;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class GeekA01 {

    /**
     * 循环个数为顶点个数
     */
    private List<Integer>[] glist;

    /**
     * 记录顶点遍历状态：1:已遍历
     */
    int[] vs;

    /**
     * @param n 顶点个数
     */
    @SuppressWarnings("unchecked")
    public GeekA01(int n) {
        glist = new ArrayList[n];
        vs = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            vs[i] = 0;
        }
        for (int i = 0; i < glist.length; i++) {
            glist[i] = new ArrayList<Integer>();
        }
    }


    /**
     * 是否循环依赖
     * [[1, 2], [], []]
     * [[1], [2], [3], [4], [0], []]
     *
     * @return 1-是,0-否
     */
    int loopDep() {
        //TODO:算法实现
        for (int i = 0; i < glist.length; i++) {
            return recursive(glist[i], i);
        }
        return 0;
    }


    int recursive(List<Integer> dependList, int node) {
        /*boolean contains = dependList.contains(node);
        if (contains) {
            return 1;
        }
        for (Integer dependNum : dependList) {
            vs[node] = 1;
            List<Integer> list = glist[dependNum];
        }

		return 0;*/


        boolean contains = dependList.contains(node);
        if (contains) {
            return 1;
        }
        for (Integer dependNum : dependList) {
            return recursive(glist[dependNum], node);
        }
        return 0;


    }


    void put(Integer a, Integer b) {
        if (glist[a - 1] == null) {
            glist[a - 1] = new ArrayList<Integer>();
            glist[a - 1].add(b - 1);
        } else {
            glist[a - 1].add(b - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        LineNumberReader reader = null;
        long starttime = System.currentTimeMillis();
        try {
            ClassPathResource eesource = new ClassPathResource("geekA01_simple.in");
            reader = new LineNumberReader(new FileReader(eesource.getFile()));
            // reader = new LineNumberReader(new FileReader(new File("geek02_simple.in")));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                line = line.trim();
                String[] rows = line.split(" ");
                int n = Integer.parseInt(rows[0]);
                GeekA01 t2 = new GeekA01(n);
                int m = Integer.parseInt(rows[1]);
                for (int i = 0; i < m; i++) {
                    line = reader.readLine().trim();
                    rows = line.split(" ");
                    t2.put(Integer.parseInt(rows[0]), Integer.parseInt(rows[1]));
                }
                System.out.println(t2.loopDep());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            long endtime = System.currentTimeMillis();
            System.out.println("total time = " + (endtime - starttime));
        }
    }
}
