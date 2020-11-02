package com.xjj.easy;

public class E_69_mySqrt {

    // 二分法
    public int mySqrt(int x) {
        int l = 0, r = x, ans = 0;
        while(l <= r) {
            /*
            * 拒绝使用，l+r可能超出整型溢出
            * */
            // int mid = (l+r)/2;

            /*
            * 加法变减法的思想
            * (l+r)/2 = l + (r - l) / 2；不会溢出
            * */
            int mid = l + (r - l) / 2;

            /*
            * if (mid <= x * 1.0 / mid)  乘法变除法思想
            * 错误(long)(mid * mid)  已经溢出
            *
            * */
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
