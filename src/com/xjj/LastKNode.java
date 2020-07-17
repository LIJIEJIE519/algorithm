package com.xjj;

/**
 * Created by XJJ on 2020/5/17.
 * 链表中倒数第K个节点
 */
public class LastKNode {
    /*
    * 倒数第K个即正数第（N-K+1）=(N-(K-1))个
    * 两个指针，pre前指针在前跑 K-1 个节点后，另一个rear后指针开始跑
    * 当pre跑到n ,rear所在节点即可所求
    * */
    public ListNode solution(ListNode head, int k) {
        if (head == null || k <=0)
            return null;
        // 前、后指针
        ListNode pre = head, rear = head;
        // 记录节点总数，当count < K，返回空
        int count = 0;
        int index = k;
        while (pre != null) {
            // 前指针一直跑
            pre = pre.next;
            count++;
            if (k < 1) {
                // 后指针开始跑
                rear = rear.next;
            }
            k--;
        }
        // 总数没倒数多
        if (count < index) {
            return null;
        }
        return rear;
    }


}
