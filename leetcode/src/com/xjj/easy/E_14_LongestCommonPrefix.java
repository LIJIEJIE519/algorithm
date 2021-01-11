package com.xjj.easy;

/**
 * 查找字符串数组中的最长公共前缀。
 */
public class E_14_LongestCommonPrefix {
    /*两两词比较，公共词在与后面词继续比较*/
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";

        String ans = strs[0];
        for(int i = 1; i < strs.length; i++) {
            // 根据较短字符串寻找
            int len = Math.min(ans.length(), strs[i].length());
            int j = 0;
            // 寻找前缀
            while(j < len && ans.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            // 获取公共前缀
            ans = ans.substring(0, j);
            // 任意俩没有，即NO
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
}
