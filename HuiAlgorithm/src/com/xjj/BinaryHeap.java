package com.xjj;

/**
 * Created by XJJ on 2020/5/28.
 *
 * 二叉堆
 * 最小堆的增加节点，删除节点，构建
 * 数组实现:
 * 1. leftIndex = indexP*2+1
 * 2. rightIndex = indexP*2+2
 * 3. indexP = (childIndex-1)/2
 */
public class BinaryHeap {

    /*
    * 增加节点
    * 1. 子节点上浮
    * 2. 默认增加在最后一个节点
    * 3. 每次只操作一个节点
    * 4. O(logn)
    * 上浮，操作的是子坐标
    * */
    public static void upAdjust(int[] array) {
        int childIndex = array.length-1;    //默认最后一个节点
        int parentIndex = (childIndex -1)/2;
        int temp = array[childIndex];       //保存临时值
        // 界内且孩子小于父
        while (childIndex > 0 && temp < array[parentIndex]) {
            array[childIndex] = array[parentIndex]; // 临时交换父节点--单向赋值
            childIndex = parentIndex;   //子坐标上浮
            parentIndex = (childIndex -1)/2;
        }
        //插入值归位
        array[childIndex] = temp;
    }
    /**
     * 删除节点
     * 1. 父节点下沉
     * 2. 默认删除根节点
     * 3. 每次只操作一个节点
     * 4. O(logn)
     * 下沉，操作的是父坐标
     * @param array
     * @param parentIndex 下沉的父节点
     */
    public static void downAdjust(int[] array, int parentIndex) {
        int len = array.length;
        int temp = array[parentIndex];
        int childIndex = parentIndex*2+1;
        while (childIndex < len){
            // 判断左右子节点中最小
            if (array[childIndex] > array[childIndex+1]) {
                childIndex++;
            }
            if (temp < array[childIndex])
                break;
            // 父节点大于子节点，下沉
            array[parentIndex] = array[childIndex];
            // 父坐标下沉
            parentIndex = childIndex;
            childIndex = parentIndex*2+1;
        }
        //下沉值归位
        array[parentIndex] = temp;
    }

    /**
     * 构建
     * 1. 从最后一个非叶子节点开始，依次做“下沉”调整
     * @param array
     */
    public static void build(int[] array) {
        // 从最后一个非叶子节点开始，依次做“下沉”调整
        for(int i = (array.length - 2)/2; i>=0; i--) {
            downAdjust(array, i);
        }
    }


}
