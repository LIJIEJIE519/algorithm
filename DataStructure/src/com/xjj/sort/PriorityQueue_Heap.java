package com.xjj.sort;

import java.util.PriorityQueue;

/**
 * @Author LJ
 * @Date 2020/12/16
 * msg
 */

/**
 * https://blog.csdn.net/u010623927/article/details/87179364
 * Java中PriorityQueue通过二叉小顶堆实现，
 * PriorityQueue的peek()和element()操作是常数时间，
 * add(), offer(), 无参数的remove()以及poll()方法的时间复杂度都是log(N)。
 */
public class PriorityQueue_Heap {
    public static void main(String[] args) {
        // 最小堆
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len, (a, b) -> a - b);

        // 使用一个含有 len 个元素的最大堆，lambda 表达式应写成：(a, b) -> b - a
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (a, b) -> b - a);

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        int[] nums = new int[] {3,5,6,8,2,9,1};
        for (int num : nums) {
            pq.add(num);
        }
        for (int i = 0; i < 7; i++) {
            System.out.print(pq.poll() + " ");
        }
    }
}
