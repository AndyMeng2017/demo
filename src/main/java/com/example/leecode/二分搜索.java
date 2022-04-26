package com.example.leecode;

/**
 * https://mp.weixin.qq.com/s/M1KfTfNlu4OCK8i9PSAmug
 */
public class 二分搜索 {
    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 9, 10, 20};
        System.out.println(binarySearch(a, 3));
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }
}
