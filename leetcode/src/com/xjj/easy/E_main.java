package com.xjj.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author LJ
 * @Date 2020/11/5
 * msg
 */

public class E_main {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3);
//        LinkedList<Object> list = new LinkedList<>();
//        list.add(1);
//        list.addFirst(1);

        int[] a = new int[]{1, 2, 3, 4};
        final int[] ints = Arrays.copyOf(a, 1);
//        for (int i : ints) {
//            System.out.print(i);
//        }

        for (int i : Arrays.copyOfRange(a, 0, 4)) {
            System.out.println(i);
        }

    }
}

