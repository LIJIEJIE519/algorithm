package com.xjj.sort;

/**
 * Created by XJJ on 2020/5/29.
 * 快速排序
 */
public class QuickSort {

    /**
     * 双边循环
     * @param arr
     * @param start
     * @param end
     */
    public static void sort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int pivot = arr[start]; //基准元素
        int left = start;       //左基点
        int right = end;        //右基点
        while (left < right) {
            // 必须右边先开始, 找小值索引
            while (arr[right] > pivot && left < right) {
               right--;
            }
            // 必须加上<=，否则第一个元素相同，找大值索引
            while (arr[left] <= pivot && left < right) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        // 基点归位
        swap(arr, start, left);

        sort(arr, start, left-1);   //左边归位
        sort(arr, left+1, end);     //右边归位

    }

    /**
     * 单边循环
     * 1. mark指针==小于基点元素的边界区域
     * 2. 小于基点：mark++，该点于mark点交换
     * @param arr
     * @param start
     * @param end
     */
    public static void sortOne(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        // 获得基点索引
        int mark = getMark(arr, start, end);
        sortOne(arr, start, mark-1);
        sortOne(arr, mark+1, end);
    }

    public static int getMark(int[] arr, int start, int end) {
        // 基点
        int pivot = arr[start];
        // 小于基点边界区域
        int mark = start;
        for(int i = start + 1; i <= end; i++) {
            if (arr[i] < pivot) {
                mark++;
                swap(arr, mark, i);
            }
        }
        // 基点归位
        swap(arr, start, mark);
        return mark;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,5,1,6,7};
//        sort(arr, 0, arr.length-1);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }

        System.out.println();
        sortOne(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
