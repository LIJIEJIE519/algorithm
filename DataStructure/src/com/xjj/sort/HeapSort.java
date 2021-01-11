package com.xjj.sort;

import java.util.Arrays;

/**
 * Created by XJJ on 2020/5/29.
 * 堆排序
 * 1. 升序--最大堆
 * 2. 循环将堆顶元素替换为堆尾元素（删除）
 * 3. 调整堆（下沉）
 * 4. 层次遍历输出即可
 */
public class HeapSort {

    /**
     *  下沉，操作的是父坐标
     * @param arr
     * @param parentIndex   要“下沉”的父节点
     * @param size  堆的有效大小:后面的可视为删除
     */
    public static void downAdjust(int[] arr, int parentIndex, int size) {
        int temp = arr[parentIndex];
        int childIndex = parentIndex*2+1;
        while (childIndex < size) {
            // 找子孩子中最大
            if (arr[childIndex] < arr[childIndex+1]) {
                childIndex++;
            }
            // 父节点最大
            if (temp >= arr[childIndex])
                break;
            // 子节点较大，父节点坐标下沉
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2+1;
        }
        arr[parentIndex] = temp;
    }

    // 堆排序
    public static void heapSort(int[] arr) {
        // 1. 从最后一个非叶子节点开始，依次做“下沉”调整
        for(int i = (arr.length - 2)/2; i >= 0; i--) {
            downAdjust(arr, i, arr.length-1);
        }

        System.out.println(Arrays.toString(arr));

        // 2. 循环删除堆顶元素，移到集合尾部，调整堆产生新的堆顶
        for(int i = arr.length-1; i >= 0; i--) {
            // 最后1个元素和第1个元素进行交换
            int t = arr[i];
            arr[i] = arr[0];
            arr[0] = t;
            // “下沉”调整最大堆
            downAdjust(arr, 0, i-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
