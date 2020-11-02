package com.xjj.easy;

//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() { }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class E_100_isSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*
         * 包含：两者均为空 ； 或者其中一个为空
         */
        if (p == null || q == null)
            return p == q;
        // dfs[深度搜索]
        return p.val == q.val &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }
}
