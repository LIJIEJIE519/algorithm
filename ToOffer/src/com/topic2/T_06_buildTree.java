package com.topic2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LJ
 * @Date 2020/12/10
 * msg
 */

public class T_06_buildTree {

    int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return help(0, 0, preorder.length - 1);
    }

    public TreeNode help(int root, int left, int right) {
        if (left > right)
            return null;
        TreeNode node = new TreeNode(this.preorder[root]);
        int index = map.get(preorder[root]);
        node.left = help(root+1, left,  index-1);
        //前序[根，左子树，右子树] root+index-left+1 : 下一个根=前序中取出上一个根+左子树个数(index-left) + 1
        node.right = help(root+index-left+1, index+1, right);
        return node;
    }
}
