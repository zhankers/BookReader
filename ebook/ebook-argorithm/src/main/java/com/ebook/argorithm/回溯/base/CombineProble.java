package com.ebook.argorithm.回溯.base;

import java.util.List;

public abstract class CombineProble extends Problem {
    /**
     *
     * @param k
     * @return
     */
    public abstract List<Comparable> makeIterms(int k);
    
    @Override
    public void explore(int k) {
        if (isComplete(k)) {
            flag = true;
            printSolution(k);
            return;
        }
        if (k >= n) {
            return;
        }

        List<Comparable> items = makeIterms(k);
        for(int i=0; i<items.size(); i++) {
            x[k] = items.get(i);
            if (isPartial(k)) 
                explore(k + 1);
        }
    }
}