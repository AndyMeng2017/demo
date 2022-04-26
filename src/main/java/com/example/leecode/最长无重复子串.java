package com.example.leecode;

import java.util.HashMap;

/**
 * https://mp.weixin.qq.com/s/ioKXTMZufDECBUwRRp3zaA
 */
public class 最长无重复子串 {

    public static void main(String[] args) {
        char[] a = {'p', 'w', 'w', 'k', 'e', 'w'};
        System.out.println("案例一: " + lengthOfLongestSubstring(a));

        char[] b = {'b', 'b', 'b', 'b'};
        System.out.println("案例二: " + lengthOfLongestSubstring(b));

        char[] c = {'a', 'b', 'c', 'a', 'b', 'c', 'b', 'b'};
        System.out.println("案例三: " + lengthOfLongestSubstring(c));
    }

    public static int lengthOfLongestSubstring(char[] s) {
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        int left = 0, right = 0;
        int res = 0; // 记录结果
        while (right < s.length) {
            char c = s[right];
            right++;
            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                char d = s[left];
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            // 在这里更新答案
            res = Math.max(res, right - left);
        }
        return res;
    }
}
