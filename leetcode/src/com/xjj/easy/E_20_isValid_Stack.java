package com.xjj.easy;

import java.util.*;

public class E_20_isValid_Stack {

    public boolean isValid(String s) {
        // 括号匹配
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Object> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || stack.peek() != map.get(s.charAt(i))) {
                    return false;
                }
                // 出栈
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        // 括号是否匹配全
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        E_20_isValid_Stack is = new E_20_isValid_Stack();

        // 实现双端队列接口才可
        Deque<Object> stack = new LinkedList<>();
        // 入栈
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // 获取栈顶元素
        System.out.println(stack.peek());
        // 出栈
        stack.pop();
        System.out.println(stack.peek());

        // 队列
        Queue<Object> queue = new LinkedList<>();
    }
}
