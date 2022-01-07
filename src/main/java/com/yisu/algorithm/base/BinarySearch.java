package com.yisu.algorithm.base;

/**
 * @author xuyisu
 * @description 二分查找
 * @date 2022/1/6
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int search = binarySearch(nums, target);
        System.out.println(search);

    }


    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // 变更右边界
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            // 变更左边界  (nums[mid] < target)
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
