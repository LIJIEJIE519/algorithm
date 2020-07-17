package com.xjj;

/**
 * Created by XJJ on 2020/5/12.
 * 字符串转整数
 *
 */
public class SToInt {
    public static void main(String[] args) {

    }
    public static int StrToInt(String s) {
        if (s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        // 判断符号位
        int flag = 0;
        if (chars[0] == '+')
            flag = 1;
        if (chars[0] == '-')
            flag = 2;
        //开始位，去掉符号位
        int start = flag>0 ? 1:0;
        // 保存结果
        int res = 0;
        for(int i = start; i < chars.length; i++) {
            if (Character.isDigit(chars[i])){
                int temp = chars[i] -'0';   // 获得int
                res = res * 10 +temp;
            }else {
                return 0;
            }
        }
        return flag != 2 ? res : -res;
    }
}
