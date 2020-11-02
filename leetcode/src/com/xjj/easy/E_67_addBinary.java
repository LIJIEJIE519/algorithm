package com.xjj.easy;

public class E_67_addBinary {

    public String addBinary(String a, String b) {
        // 速度快
        StringBuilder ans = new StringBuilder();
        int al = a.length();
        int bl = b.length();
        int max = Math.max(al, bl);
        // 获取进位
        int carry = 0;
        for (int i = 0; i < max; i++) {
             // 反转对位取
            carry += (i < al) ? a.charAt(al-i-1)-'0' : 0;
            carry += (i < bl) ? b.charAt(bl-i-1)-'0' : 0;
            // 当前答案
            ans.append(carry % 2);
            // 进位
            carry /= 2;
        }
        if (carry != 0)
            ans.append(1);
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        // 2进制转10进制
        System.out.println(Integer.parseInt("11", 2));

        // 10进制转2进制
        System.out.println(Integer.toBinaryString(10));
    }
}
