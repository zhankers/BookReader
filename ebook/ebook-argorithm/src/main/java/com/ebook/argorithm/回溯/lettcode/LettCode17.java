package com.ebook.argorithm.回溯.lettcode;

import com.ebook.argorithm.回溯.base.BackTrack;
import com.ebook.argorithm.回溯.base.CombineProble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-06-06 15:31
 */
public class LettCode17 {
    public List<String> letterCombinations(String digits) {
        TelNoCombine telNoCombine = new TelNoCombine(digits);
        BackTrack.backtrack(telNoCombine);
        return telNoCombine.xList;
    }

    public static void main(String[] args) {
        List<String> strings = new LettCode17().letterCombinations("");
        System.out.println(strings);
    }
}

class TelNoCombine extends CombineProble {

    String[] letters = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    String digits;
    List<String> xList;

    public TelNoCombine(String digits) {
        this.digits = digits;
        this.n = digits.length();
        this.x = new String[n];
        this.xList = new ArrayList<>();
    }

    @Override
    public List<Comparable> makeIterms(int k) {
        char c = digits.charAt(k);
        int index = c - '0';
        return Arrays.asList(letters[index].split(""));
    }

    @Override
    public boolean isComplete(int k) {
        return k >= digits.length();
    }

    @Override
    public void printSolution(int k) {
        if (!"".equals(digits))
            xList.add(String.join("", (String[]) x));
    }

    @Override
    public boolean isPartial(int k) {
        if (k < digits.length())
            return true;
        return false;
    }
}
