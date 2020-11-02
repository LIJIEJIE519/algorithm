package com.xjj.easy;

public class E_70_climbStairs {
    /*
    * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    * */


    /*
    * 1. 递归--dfs
    * 超时
    * */

    public int climbStairs(int n) {
        if (n == 0) return 1;       // 1，1，1
        if (n < 0) return 0;
        int ans = 0;
        // 1 or 2 steps
        for (int i = 1; i <=2; i++) {
            ans += climbStairs(n-i);
        }
        return ans;
    }


    /*
    * 动态规划
    * f(x) = f(x-1) + f(x-2)
    * 理解为：一共n阶台阶，到最后一个选择时，有两种选择：【无视前面走法， 例如4】
    *       ​ 1.走一步【1,1,1; 1,2; 2,1] -> 1
    *       ​ 2.走两步【1,1; 2】-> 2
    * */

    public int climbStairsD(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }



}
