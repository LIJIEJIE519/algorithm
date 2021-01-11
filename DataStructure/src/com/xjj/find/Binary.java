package com.xjj.find;

/**
 * @Author LJ
 * @Date 2020/12/25
 * msg
 */

public class Binary {

    public static void main(String[] args) {
        int[] a = {5,7,7,8,8,10};
        System.out.println(binarySearch(a, 5, false));  // 返回5的索引
        System.out.println(binarySearch(a, 5, true));   // 返回第一个大于5的索引

        System.out.println(binarySearch(a, 11, false));   // 6
    }

    /**
     *
     * @param nums      数组
     * @param target    待查找目标数，如果存在，返回其索引；如果不存在，返回第一个大于target的索引
     * @param firstBig     false-查找目标数的索引; true-查找第一个大于target的索引
     * @return
     */
    public static int binarySearch(int[] nums, int target, boolean firstBig) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (firstBig && nums[mid] >= target)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
