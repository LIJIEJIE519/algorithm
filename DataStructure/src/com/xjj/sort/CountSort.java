package com.xjj.sort;

import java.util.Arrays;

/**
 * Created by XJJ on 2020/6/2.
 *
 * 计数排序
 * 1. 先按值入数组arr(++)
 * 2. 累加arr以获得相应数据的最终排序
 * 3. 创建sortArr后遍历arr获得排序入sortArr
 */
public class CountSort {
    public static int[] sort(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        //数组长度=max-min+1
        //偏移量=min
        int d = max - min;
        int[] countArr = new int[d+1];
        //1. 统计对应元素的个数
        for (int i = 0; i < arr.length; i++) {
            // 真实值
            int temp = arr[i];
            countArr[temp-min]++;
        }
        /**
        * 2. 统计数组做变形，后面的元素等于前面的元素之和
        * 获得相应数据的最终排序
        * arr = {1,0,1,2}-->{1,1,2,4}[]
        * */
        for (int i = 1; i < arr.length; i++) {
            countArr[i] += countArr[i-1];
        }
        /**
         * 3. 倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
         * 创建sortArr后遍历arr获得排序入sortArr
         * */
        int[] sortArr = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            // 跨度，数组坐标
            int step = arr[i] - min;
            // 获得对应元素的排序号
            int sort = countArr[step];
            // 归位
            sortArr[sort-1] = arr[i];
            // 下次有该数时排名前移-->稳定排序
            countArr[step]--;
        }
        return sortArr;
    }

    public static void main(String[] args) {
        int[] array = new int[] {95,94,91,98,99,90,99,93,91,92};
        int[] sortedArray = sort(array);
        System.out.println(Arrays.toString(sortedArray));
    }


}
