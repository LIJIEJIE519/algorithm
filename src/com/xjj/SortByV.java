package com.xjj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by XJJ on 2020/5/10.
 *
 * 自定义按值排序
 *
 */
public class SortByV implements Comparable<SortByV>{
    private String name;
    private int age;
    public SortByV(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
    * 要想实现类按某值排序，必须实现该方法
    * 本按age排序
    * */
    @Override
    public int compareTo(SortByV o) {
        // 升序
//        return this.age > o.age ? 1 : 0;
        // 降序
        return o.age > this.age ? 1 : 0;
    }

    public static void main(String[] args) {
        ArrayList<SortByV> list = new ArrayList<>();
        list.add(new SortByV("xj",1));
        list.add(new SortByV("xjj",3));
        list.add(new SortByV("xjjjj",6));
        list.add(new SortByV("xjjjjjj",2));

        for (SortByV s : list) {
            System.out.println(s.getName() + "-" + s.getAge());
        }
        list.sort((o1, o2) -> o1.age);

//        Collections.sort(list, new Comparator<SortByV>() {
//            @Override
//            public int compare(SortByV o1, SortByV o2) {
//                return o1.compareTo(o2);
//            }
//        });
        for (SortByV s : list) {
            System.out.println(s.getName() + "-" + s.getAge());
        }

    }

}
