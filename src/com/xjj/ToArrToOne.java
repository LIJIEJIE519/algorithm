package com.xjj;

/**
 * Created by XJJ on 2020/5/13.
 */
public class ToArrToOne {
    public int[] reverseMergeSortArray(int[] a, int[] b) {
        int aIndex = a.length-1;
        int bIndex = b.length-1;
        int[] c = new int[a.length + b.length];
        for(int i = 0; i < c.length; i++) {
            if(aIndex >= 0 && bIndex >= 0) {
                if(a[aIndex] > b[bIndex]) {
                    c[i] = a[aIndex];
                    aIndex--;
                }else {
                    c[i] = b[bIndex];
                    bIndex--;
                }
            }else {
                if (aIndex < 0) {
                    c[i] = b[bIndex];
                    bIndex--;
                }else {
                    c[i] = a[aIndex];
                    aIndex--;
                }
            }
        }
        return c;
    }
}
