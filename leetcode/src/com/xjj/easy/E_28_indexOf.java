package com.xjj.easy;

public class E_28_indexOf {
    /*
    * 长字符串里选择子字符串，返回索引
    * */

    /*
    * 1. 逐一匹配
    * O((m-n)n)
    * */

    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);
        // 逐串比较
        int max = haystack.length();
        int min = needle.length();
        if (min == 0) return 0;

        // 只需比较max-min
        for(int i = 0; i <= max-min; i++) {
            int j = 0;
            for(; j < min; j++) {
                // 不相等就退出
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
            }
            // 匹配完字串
            if (j == min)
                return i;
        }
        return -1;
    }

}
