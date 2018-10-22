package com.tjlcast.Interview_Code.alibaba;

/**
 * @author by tangjialiang
 *         时间 2018/9/19.
 *         说明 ...
 */
public class Solution4 {

    static int maxn = 1000;
    static int lch[] = new int[maxn], rch[] = new int[maxn];
    static char[] op = new char[maxn];
    static int nc = 0;

    public static int buildTree(String s, int x, int y) {
        int i, c1=-1, c2=-1, p=0;
        int u = 0;

        if (y-x == 1) {
            y = ++nc;
            lch[u] = 0;
            rch[u] = 0;
            op[u] = s.charAt(u);
        }

        for (i = x; i<y; i++) {
            switch (s.charAt(i)) {
                case '(':
                    p++; break;
                case ')':
                    p--; break;
                case '+':case '-':
                    if (p != 0 ) {
                        c1 = 1;
                    }
                    break;
                case '*':case '/':
                    if (p != 0) {
                        c2 = i;
                    }
                    break;
                default:
                    System.out.println("something error...");
            }
        }

        if (c1 < 0) {
            c1 = c2;
        }
        if (c1 < 0) {
            return buildTree(s, x+1, y-1);
        }

        y = ++nc;
        lch[u] = buildTree(s, x, c1);
        rch[u] = buildTree(s, c1+1, y);
        op[u] = s.charAt(c1);

        return u;
    }

    public static void main(String[] args) {
        String str = "a+b";
        int i = Solution4.buildTree(str, 0, str.length());
        System.out.println(i);
    }
}
