package com.xjj.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author LJ
 * @Date 2020/11/5
 * msg
 */


public class E_107_levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        /*层次遍历， 往结果集头部插*/
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size > 0) {
                TreeNode curr = queue.poll();
                temp.add(curr.val);
                TreeNode l = curr.left, r = curr.right;
                if (l != null)
                    queue.offer(l);
                if (r != null)
                    queue.offer(r);
                size--;
            }
            result.add(0, temp);
        }
        return result;
    }

}
