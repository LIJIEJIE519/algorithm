package com.xjj;

/**
 * Created by XJJ on 2020/5/12.
 * 最长公共子序列（可不连续，相对位置不变）
 *
 * 对任意字符串，如果头和尾相同，那么它的最长回文子序列为去头去尾之后部分的最长回文子序列加上头和尾。
 * f(0,n-1)=f(1,n-2)+2
 * 如果头和尾不同，那么它的最长回文子序列是去头的部分的最长回文子序列和去尾的部分的最长回文子序列的较长的那一个。
 * f(0,n-1)=max(f(1,n-1),f(0,n-2))
 */
public class LongestPalindromeSubseq {
    public static void main(String[] args) {
        System.out.println(solution("abbbaba"));    //6
    }

    public static int solution(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        // 从内向外扩，i向右，j向左
        for(int i = len-1; i >=0; i--) {
            dp[i][i] = 1;
            for(int j = i+1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
