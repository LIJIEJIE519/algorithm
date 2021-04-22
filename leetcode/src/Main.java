import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

class Node {
    int val;
    Node next = null;
    Node pre = null;
    public Node(){};
    public Node(int val) {
        this.val = val;
    }
}

public class Main {

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = Integer.parseInt(in.nextLine());
            String s = in.nextLine();
            Node dump = new Node();
            Node curr = dump;
            for (int i = 0; i < n; i++) {
                final Node node = new Node(Integer.parseInt(s.charAt(i) + ""));
                curr.next = node;
                node.pre = curr;
                curr = node;
            }
            curr = dump;
            Node p = curr.next;
            Node q = p.next;
            while (q != null) {
                if (p.val + q.val == 10) {
                    curr.next = q.next;
                    p = curr;
                    q = p.next;
                    curr = curr.pre;
                } else {
                    curr = p;
                    p = q;
                    q = q.next;
                }
            }
            curr = dump.next;
            int sum = 0;
            while (curr != null) {
                sum++;
                curr = curr.next;
            }
            System.out.println(sum);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bf.readLine()) != null) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = Integer.parseInt(line);
            String s = bf.readLine();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(s.charAt(i)+""));
            }
            int i = 0;
            while (i < list.size()-1) {
                if (list.get(i) + list.get(i+1) == 10) {
                    list.remove(i);
                    list.remove(i);
                    if (i != 0) {
                        i--;
                    }
                } else {
                    i++;
                }
            }
            System.out.println(list.size());
        }

        Queue<String> queue = new LinkedList<>();
    }

}




///**
//public class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     * 你需要返回一个指针，指向root，表示删减去若干个点后，剩下的树
//     * @param root TreeNode类 指向二叉树的根
//     * @return TreeNode类
//     */
//    public TreeNode solve (TreeNode root) {
//        if (root == null)
//            return null;
//        Queue<TreeNode> queue = new LinkedList<>();
//        Queue<TreeNode> parent;
//        queue.add(root);
//        int bea = 1;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            parent = new LinkedList<>();
//            while (size > 0) {
//                TreeNode node = queue.poll();
//                parent.add(node);
//                if (node.left != null && node.right != null) {
//                    queue.add(node.left);
//                    queue.add(node.right);
//                }
//                size--;
//            }
//            bea *= 2;
//            if (queue.size() != bea) {
//                while (!parent.isEmpty()) {
//                    TreeNode node = parent.poll();
//                    node.left = null;
//                    node.right = null;
//                }
//                break;
//            }
//
//        }
//        return root;
//    }
//}
//
//**/