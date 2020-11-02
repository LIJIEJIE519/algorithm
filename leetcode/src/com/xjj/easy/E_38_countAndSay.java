package com.xjj.easy;

public class E_38_countAndSay {
    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder();
        if (n == 1)
            return "1";
        if (n == 2)
            return "11";
        String str = countAndSay(n-1);
        // String res = "";
        int num = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i-1) == str.charAt(i)) {
                num += 1;
            } else {
                // res += num+""+str.charAt(i-1);
                s.append(num).append(str.charAt(i-1));
                num = 1;
            }
            if (i == str.length()-1) {
                // res += num+""+str.charAt(i);
                s.append(num).append(str.charAt(i));
            }
        }
        return s.toString();
    }


    /*
    * String -- StringBuffer -- StringBuilder
    *
    *
    * 1.String 是final对象，不会被修改，每次使用 + 进行拼接都会创建新的对象，而不是改变原来的对象；速度最慢
    * 2.StringBuffer 可变字符串，主要用于字符串的拼接，属于线程安全的；
    * 3.StringBuilder 可变字符串，主要用于字符串的拼接，属于线程不安全的；速度最快
    * */


    /**
     * StringBuilder拼接，线程不安全，速度最快（10000条记录大概0毫秒）
     */
    public static void getStringBuilderTime(){
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 10000;i++){
            sb.append(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * StringBuffer拼接，线程安全，速度略快（10000条记录大概6毫秒）
     */
    public static void getStringBufferTime(){
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < 10000;i++){
            sb.append(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * String拼接，线程安全，速度最慢（10000条记录大概350毫秒）
     */
    public static void getStringTime(){
        long start = System.currentTimeMillis();
        String sb = new String();
        for(int i = 0;i < 10000;i++){
            sb += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        getStringTime();
        getStringBufferTime();
        getStringBuilderTime();
    }
}
