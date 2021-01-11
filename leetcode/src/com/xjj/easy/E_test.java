package com.xjj.easy;

import java.util.*;

public class E_test {

    public static void main(String[] args) {
        String[] strings = {"ac","c"};
        Arrays.sort(strings, Comparator.comparingInt(String::length));
        System.out.println(strings[0]);

        Map<String, List<String>> map = new HashMap<String, List<String>>();
    }
}