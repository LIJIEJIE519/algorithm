package com.xjj.easy;

public class Reverse {
    /*
    * 1. 数字反转，123-->321
    * 2. 防止溢出
    * */

    public static void main(String[] args) {
//        System.out.println(reverse(-250));
    }

    // int数反转
    public int reverse(int x) {
        int ans = 0;
        int temp = 0;  // 为上一次*10
        while (x != 0) {
            // *升位 /降位 %取个位
            ans = ans * 10 + x % 10;
            // 防止溢出--ans溢出/10一定不等于temp,
            if (temp != ans/10)
                return 0;
            temp = ans;
            x = x / 10;
        }
        return ans;
    }


    // 判断回文数，可以只取一半
    public boolean isPalindrome(int x) {
        return x == reverse(x);
    }

    // 反转一半(+2)数字, 回文下--> x>=ans得一半了
    public boolean isPalindrome2(int x) {
        if(x < 0 || (x%10==0 && x != 0))
            return false;

        int ans = 0;
        while(x > ans) {
            ans = ans * 10 + x % 10;
            x = x/10;
        }
        return x == ans || x == ans/10;
    }
}
