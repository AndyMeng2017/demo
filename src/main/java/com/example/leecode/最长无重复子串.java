package com.example.leecode;

import java.util.HashMap;

/**
 * https://mp.weixin.qq.com/s/ioKXTMZufDECBUwRRp3zaA
 */
public class 最长无重复子串 {

    public static void main(String[] args) {
        char[] a = {'p', 'w', 'w', 'k', 'e', 'w'};
        System.out.println("案例一: " + lengthOfLongestSubstring1(a));
        System.out.println("案例二: " + lengthOfLongestSubstring2(a));

        char[] b = {'b', 'b', 'b', 'b'};
        System.out.println("案例一: " + lengthOfLongestSubstring1(b));
        System.out.println("案例二: " + lengthOfLongestSubstring2(b));

        char[] c = {'a', 'b', 'c', 'a', 'b', 'c', 'b', 'b'};
        System.out.println("案例一: " + lengthOfLongestSubstring1(c));
        System.out.println("案例三: " + lengthOfLongestSubstring2(c));
    }

    public static int lengthOfLongestSubstring1(char[] s) {
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

    public static int lengthOfLongestSubstring2(char[] chas) {
        if(chas == null || chas.length == 0){
            return 0;
        }
        int pre = -1;
        int cur = 0;
        int len = 0;
        int[] map = new int[256];
        for(int i = 0; i < 256; i++){
            map[i] = -1;
        }
        for(int i = 0; i < chas.length; i ++){
            pre = Math.max(pre, map[chas[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[chas[i]] = i;
        }
        return len;
    }
}
