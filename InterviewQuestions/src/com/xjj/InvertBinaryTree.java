package com.xjj;

import com.DataStructures.TreeNode;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by XJJ on 2020/5/26.
 *
 * 反转二叉树--小米面试（2020.5.25）
 * 没解决
 */
public class InvertBinaryTree {
/*    // 二叉树
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }*/

    static public String[] arr = {"1", "2", "3", "#", "4", "#", "#", "5", "6", "#", "#", "#", "7",
            "8", "#", "#", "9", "10", "#", "#", "11", "#", "#"};
    static int i = 0;
    static TreeNode root = null;
    public static void main(String[] args) {
        InvertBinaryTree binaryTree = new InvertBinaryTree();
        root = createTree(root);

        binaryTree.levelTraverse(root);
        binaryTree.solution(root);
        binaryTree.levelTraverse(root);
    }

    /**
     * 递归解决
     * 从上到下开始反转，然后左节点，在右节点
     *
     * */
    public void solution(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null || root.right == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        solution(root.left);
        solution(root.right);
    }

    /**
     * 递归创建二叉树
     * */
    public static TreeNode createTree(TreeNode root) {
        if (arr[i].equals("#")){
            i++;
            // null
            return null;
        }
        root = new TreeNode(Integer.parseInt(arr[i]));
        i++;
        root.left = createTree(root.left);
        root.right = createTree(root.right);
        return root;
    }

    /**
     * 层次遍历
     * 利用队列先进先出
     * */
    public void levelTraverse(TreeNode root) {
        if(root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        TreeNode node;
        queue.add(root);
        while (!queue.isEmpty()) {
            node = queue.removeFirst();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
