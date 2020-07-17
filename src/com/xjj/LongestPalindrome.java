package com.xjj;

import java.util.HashSet;

/**
 * Created by XJJ on 2020/5/9.
 * 在给定字符串中构建最长回文串--P156--JavaGuide
 * 1. 字符串出现为双数的组合
 * 2. 双数的组合+1个单字符
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println("可构建的最长回文为：" + solution(s));
    }

    public static int solution(String s) {
        if (s.length() == 0)
            return 0;

        int count = 0;      // 双字符计算
        HashSet<Character> hashSet = new HashSet();    // 存储不重复字符
        char[] chars = s.toCharArray();
        int length = chars.length;
        for(int i = 0; i < length; i++) {
            if(!hashSet.contains(chars[i])) {
                //还未出现双字符
                hashSet.add(chars[i]);
            }else {
                // 出现双字符
                count++;
                // 移除，出现4-6...个时
                hashSet.remove(chars[i]);
            }
        }
        return hashSet.isEmpty() ? count*2 : count*2+1;
    }


}
