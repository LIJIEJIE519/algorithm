package com.xjj.easy;

public class E_27_removeElement {

    /*
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     */
    public int removeElement(int[] nums, int val) {
        /*
         * 1. 重点：元素的顺序可以改变
         * 2. 思路：两个指针i、j，i 找val, 另一个j从后面找不是val填充 i 的val
         */

        int i = 0;
        int j = nums.length-1;
        while (i <= j) {
            if (nums[i] == val) {
                for (; j >=0 && nums[j] == val; j--);
                // [1,2,2] 2 : j < i
                if (j < i) break;
                nums[i] = nums[j];
                j--;
            }
            i++;
        }
        // 上处已经i++, 故此处无需在++ 得 len
        return i;
    }
}
