package com.xjj.easy;

public class E_53_maxSubArray {

    public int maxSubArray(int[] nums) {

        /*
         * 只考虑当前 nums[i], 上一个值的最大值+当前值是否大于当前值，
         *    是，则加入到子数组； 否，则当前值更大
         * 比较大小用Math.max();
         * //如果需要返回子数组??
         *
         */
        int pre_max = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (pre_max + nums[i] >= nums[i]) {
                pre_max = pre_max + nums[i];
            } else {
                pre_max = nums[i];
            }

            if (pre_max > max) {
                max = pre_max;
            }
        }

        return max;
    }

    public int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new E_53_maxSubArray().maxSubArray(a));
    }
}


