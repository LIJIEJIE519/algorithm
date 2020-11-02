package com.xjj.easy;

public class E_26_removeDuplicates {


    /*
    * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    * */


    public int removeDuplicates(int[] nums) {
        /*
         * 两个指针监听：一个指向唯一，另一个找唯一
         */
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            // 当不相等时，将新唯一赋予当前下一个元素，新唯一变唯一
            if (nums[i] != nums[j]) {
                nums[i+1] = nums[j];
                i++;
            }
        }
        // len = 0+1
        return i+1;
    }
}
