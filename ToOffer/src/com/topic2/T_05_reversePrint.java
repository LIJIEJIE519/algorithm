package com.topic2;

import com.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author LJ
 * @Date 2020/12/9
 * msg
 */



public class T_05_reversePrint {

    public int[] reversePrint(ListNode head) {
        if(head == null)
            return new int[0];

        Deque<ListNode> stack = new LinkedList<>();

        ListNode temp = head;
        while(temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int[] ans = new int[stack.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = stack.pop().val;
        }
        return ans;
    }
}
