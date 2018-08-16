package com.tjlcast.Interview_Code.tx;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2018/8/4.
 */
public class GenerateKouHao {

    private int n;
    private char[] strs;
    private List<String> ans;

    public GenerateKouHao(int n) {
        this.n = n ;
        this.strs = new char[n*2];
        this.ans = new LinkedList<>();
    }

    private void generate(int idx, int leftN, int rightN) {
        if (leftN < rightN) {
            return;
        }

        if (leftN==n && rightN==n) {
            ans.add(new String(strs));
            return ;
        }

        if (leftN < n) {
            strs[idx] = '(';
            generate(idx+1, leftN+1, rightN);
        }
        if (leftN > rightN) {
            strs[idx] = ')';
            generate(idx+1, leftN, rightN+1);
        }

        return;
    }

    public List<String> getAns() {
        generate(0, 0, 0);
        return this.ans;
    }


    public static void main(String[] args) {
        int n = 3;
        GenerateKouHao generateKouHao = new GenerateKouHao(n);
        List<String> ans = generateKouHao.getAns();

        for(String str : ans) {
            System.out.println(str);
        }
    }
}
