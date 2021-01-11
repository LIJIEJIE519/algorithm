package com.xjj.easy;

import java.util.Arrays;

/**
 * @Author LJ
 * @Date 2020/11/8
 * msg 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 */

public class E_108_sortedArrayToBST {
    /*
    * 思路：递归，总选数组的中间点作为根节点，即中序遍历
    * 排序数组
    * */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        if (nums.length == 1)
            return new TreeNode(nums[0]);

        // 选择数组中间节点
        int mid = nums.length / 2;
        // 为根节点
        TreeNode tree = new TreeNode(nums[mid]);
        // 左半数组[0, mid]为左节点
        tree.left = sortedArrayToBST(Arrays.copyOf(nums, mid));
        // 右办数组[mid, length]为右节点
        tree.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, nums.length));
        return tree;
    }

}
