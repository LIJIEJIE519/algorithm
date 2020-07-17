package five;

/**
 * Created by XJJ on 2020/6/18.
 * 判断链表是否有环
 *  1. 追及问题
 *  2. 环形跑道上，两个运动员从同一地点起跑，一个运速度快，一个速度慢。
 *      一段时间后，速度快的必然会再次追上并超过速度慢的
 */
public class IsCycle {

    // 节点
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    /*
    * 判断时候有环
    *   p1每次移动一个节点，p2每次移动两个节点
    *   当p1==p2时，说明有环
    * */
    public static boolean solution(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                int length = cycleLength(p1);
                System.out.println("环长： " + length);
                return true;
            }
        }
        return false;
    }
    public static int cycleLength(Node meetNode) {
        Node p1 = meetNode;
        Node p2 = meetNode;
        int step = 1; // 1代表最后一步相遇点
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) break;
            else step++;
        }
        return step * 1;
    }


    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        Node node6 = new Node(8);
        Node node7 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node4;

        System.out.println(solution(node1));
    }



}
