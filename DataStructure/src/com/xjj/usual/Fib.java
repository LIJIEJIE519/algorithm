package com.xjj.usual;

/**
 * @Author LJ
 * @Date 2020/12/26
 * msg
 */

public class Fib {
    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    public static long fib(int n) {
        int[] a = {0,1};
        if (n < 2)
            return a[n];
        long one = 0, two = 1, ans = 0;
        for(int i = 2; i <= n; i++) {
            ans = one + two;
            one = two;
            two = ans;
        }
        return ans;
    }
}
