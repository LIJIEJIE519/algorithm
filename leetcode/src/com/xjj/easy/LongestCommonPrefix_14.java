package com.xjj.easy;

public class LongestCommonPrefix_14 {
    /*两两词比较，公共词在与后面词继续比较*/
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";

        String ans = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int len = ans.length() > strs[i].length() ? strs[i].length() : ans.length();
            int j = 0;
            while(j < len && ans.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
}
