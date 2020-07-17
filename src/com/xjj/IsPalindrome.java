package com.xjj;

/**
 * Created by XJJ on 2020/5/9.
 * 判断是否是回文--仅考虑数字与字母，忽略大小写--P157--JavaGuide
 */
public class IsPalindrome {
    public static void main(String[] args) {
        String s = "";
        System.out.println("可构建的最长回文为：" + solution(s));
    }
    public static boolean solution(String s) {
        if (s.length() == 0)
            return true;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if(!Character.isLetterOrDigit(s.charAt(l))) {
                // 非字符或数字
                l++;
            }else if(!Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }else if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;   // 一不相等就一定不是回文串
            }
            l++;
            r--;
        }
        return true;
    }

}
