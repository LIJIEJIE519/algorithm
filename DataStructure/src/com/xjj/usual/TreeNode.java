package com.xjj.usual;

/**
 * @Author LJ
 * @Date 2021/3/26
 * msg
 */

public class TreeNode {
    class Node {
        int val;
        Node left;
        Node right;
        public Node() {}
        public Node(int val) {
            this.val = val;
        }
    }

    // 用数组建立普通二叉树
    public Node buildBinaryTree(Node root, int[] arr, int index) {
        if (index > arr.length/2)
            return root;
        if (index == 0)
            root.val = arr[0];
        root.left = new Node(arr[index*2 + 1]);
        root.right = new Node(arr[index*2 + 2]);
        buildBinaryTree(root.left, arr,index + 1);
        buildBinaryTree(root.right, arr,index + 2);
        return root;
    }
}
