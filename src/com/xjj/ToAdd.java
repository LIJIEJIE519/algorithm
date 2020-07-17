package com.xjj;

/**
 * Created by XJJ on 2020/5/17.
 * 两链表数相加
 *
 */
// 链表
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}
public class ToAdd {

    public ListNode solution(ListNode L1, ListNode L2) {
        ListNode head = new ListNode(0);    // head节点
        ListNode p = L1, q = L2, current = head;
        // 进位数
        int carry = 0;
        while (p != null || q != null) {

            int a = p != null ? p.val : 0;
            int b = q != null ? q.val : 0;
            int sum = carry + a + b;
            carry = sum / 10;
            current.next = new ListNode(carry % 10);
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }

}
