package com.xjj.easy;

import java.util.HashMap;
import java.util.Map;

public class E_1_TwoSum {

    /*
     * 1. 使用hashmap:查找元素为O(1)
     * 2. b = tar-a is in nums
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            // map包含减值，获取val[i]
            if(map.containsKey(target - nums[i]))
                return new int[] {map.get(target-nums[i]), i};
            // 关键步，将数组存入map
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
