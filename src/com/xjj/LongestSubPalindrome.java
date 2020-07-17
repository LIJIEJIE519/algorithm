package com.xjj;

/**
 * Created by XJJ on 2020/5/10.
 * 给定字符串中最长回文串
 *
 */
public class LongestSubPalindrome {

    int index = 0; //回文七点坐标
    int len = 0;   // 回文相隔长度
    public static void main(String args[]) {
        String s = "babad";
        System.out.println(new LongestSubPalindrome().lgSubP(s));
    }

    public String lgSubP(String s) {
        if (s.length() < 2) {
            return s;
        }
        for(int i = 0; i < s.length(); i++) {
            PalindromeHelper(s, i, i);   // 单字符时遍历
            PalindromeHelper(s, i, i+1); // 双字符时遍历
        }
        return s.substring(index, len); // 不取len，故下文r-l-1
    }

    public void PalindromeHelper(String s, int l, int r) {
        // 在范围内为回文
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // l向左移， r向右移
            l--;
            r++;
        }
        if (len < r-l-1) {
            //回文开始坐标，因为上面-1，所以此处+1
            index = l+1;
            len = r-l-1;
        }
    }
}
