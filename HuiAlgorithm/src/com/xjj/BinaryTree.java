package com.xjj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by XJJ on 2020/5/28.
 * 二叉树
 * 递归遍历
 */
public class BinaryTree {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(){};
        public TreeNode(int data){
            this.data = data;
        }
    }

    /*
    * 创建节点
    * */
    public static TreeNode create(LinkedList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        TreeNode node = null;
        Integer data = list.removeFirst();  //获取头节点
        if (data != null) {
            node = new TreeNode(data);
            node.left = create(list);
            node.right = create(list);
        }
        return node;
    }

    /*
    * 前序遍历
    * */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraveral(node.left);
        preOrderTraveral(node.right);
    }

    /*
    * 中遍历
    * */
    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrderTraveral(node.left);
        System.out.print(node.data + " ");
        preOrderTraveral(node.right);
    }

    /*
    * 后序遍历
    * */
    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrderTraveral(node.left);
        preOrderTraveral(node.right);
        System.out.print(node.data + " ");
    }

    /*
    * 层次遍历
    * 队列
    * */
    public void levelOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // offer()[满时返回false] == add()[满时抛出异常]
        queue.offer(node);
        while (queue != null) {
            TreeNode n = queue.poll();
            System.out.println(n.data);
            if (n.left != null) {
                queue.offer(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
            }
        }
    }


    public static void main(String[] args) {
        Integer[] is = {3, 2, 9, null, null, 10, null, null, 8, null, 4};
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(is));
        TreeNode treeNode = create(list);
        System.out.println("前序遍历============");
        preOrderTraveral(treeNode);

        System.out.println();
        System.out.println("中序遍历============");
        inOrderTraveral(treeNode);

        System.out.println();
        System.out.println("后序遍历============");
        postOrderTraveral(treeNode);
    }
}
