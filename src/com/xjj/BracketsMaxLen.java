package com.xjj;

import java.util.Scanner;

/**
 * Created by XJJ on 2020/5/12.
 * 正确括号序列的最大深度
 * ((())) = 3; ()()()=1
 *
 */
public class BracketsMaxLen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int nl = 0, max = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                nl++;
            else
                nl--;
            max = Math.max(nl, max);
        }
        scanner.close();
        System.out.println(max);
    }
}
