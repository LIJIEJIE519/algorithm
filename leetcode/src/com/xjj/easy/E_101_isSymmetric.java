package com.xjj.easy;


import java.util.LinkedList;
import java.util.Queue;

/*给定一个二叉树，检查它是否是镜像对称的。
* */
public class E_101_isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        // 迭代方法，使用队列
        return check(root, root);
    }

    /*
    * 每次入两个节点，取两个节点，两个指针p--left, q--right
    * 1. 入p节点的左节点+入q节点的右节点
    * 2. 入p节点的右节点+入q节点的左节点
    *   左子树的左孩子 == 右子树的右孩子
    *   左子树的右孩子 == 右子树的左孩子
    *
    * */
    public boolean check(TreeNode m, TreeNode n) {
        // 使用队列
        Queue<TreeNode> queue = new LinkedList<>();
        // offer 入节点，当队列满时返回false
        queue.offer(m);
        queue.offer(n);
        // 直到队空
        while (!queue.isEmpty()) {
            // poll 返回并移除头节点，队列为空，返回null
            m = queue.poll();
            n = queue.poll();
            if (m == null && n == null)
                continue;
            // 先判断是否为空，在取值
            if (m == null || n == null || m.val != n.val)
                return false;

            queue.offer(m.left);
            queue.offer(n.right);

            queue.offer(m.right);
            queue.offer(n.left);
        }
        return true;
    }


}
