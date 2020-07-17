package com.xjj.sort;

/**
 * Created by XJJ on 2020/5/28.
 * 冒泡排序：每次将最大的冒出
 * 升序排序
 * 1. 优化一：有序标记=true，break
 * 2. 优化二：有序区的界定
 * 3. 鸡尾酒排序：左到右-->右到左-->左到右...
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3,4,1,2,5,6,7,8};
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        sortOp(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        sortCo(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /*
    * 原始冒泡
    * */
    public static void sort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len-1; i++) {
            for(int j = 0; j < len-1-j; j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    /*
    * 优化冒泡
    *     {3,4,1,2,5,6,7,8}
    * 1-> {3,1,2,4,5,6,7,8}
    * 2-> {1,2,3,4,5,6,7,8}
    * 3-> {1,2,3,4,5,6,7,8} [break]
    * */
    public static void sortOp(int[] arr) {
        int len = arr.length;
        // 无序序列的边界，只需遍历到这
        int sortBorder = len-1;
        int lastChange = 0;
        for(int i = 0; i < len-1; i++) {
            // 默认已经有序，
            Boolean isSorted = true;
            for(int j = 0; j < sortBorder; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // 如果发生交换操作，则无序继续排序
                    isSorted = false;
                    // 最后一次交换元素的位置
                    lastChange = j;
                }
            }
            // 已经有序，退出
            if (isSorted) {
                break;
            }
            // 无序序列边界
            sortBorder = lastChange;
        }
    }

    /*
    * 冒泡--鸡尾酒优化
    * 双端遍历
    *     {2,3,4,5,6,7,8,1}
    * 1-> {2,3,4,5,6,7,1,8}
    * 2-> {1,2,3,4,5,6,7,8}：右到左
    * 3-> {1,2,3,4,5,6,7,8} [break]
    * */
    public static void sortCo(int[] arr) {
        int len = arr.length;
        int temp = 0;
        for (int i = 0; i < len-1; i++) {
            boolean isSorted = true;
            for(int j = i; j < len-1-i; i++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            isSorted = true;
            // 偶数轮，从右向左比较和交换
            for (int j = len-1-i; j > i; j--) {
                if (arr[j] < arr[j-1]) {
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

}
