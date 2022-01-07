package com.yisu.algorithm.base;

/**
 * @author xuyisu
 * @description 有序数组的平方
 * @date 2022/1/6
 */
public class SortSearch {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int[] search = sortedSquares2(nums);
        for (int i = 0; i < search.length; i++) {
            System.out.printf(search[i]+" ");
        }

    }


    private static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = nums[j] * nums[j];
                ++j;
            } else if (j == n) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else {
                ans[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }

    public static int[] sortedSquares2(int[] nums) {
        // 左指针，指向原数组最左边
        int left = 0;
        // 有指针，指向原数组最右边
        int right = nums.length - 1;
        // 创建一个新数组，存储平方值
        int[] result = new int[nums.length];
        // 得到元素值平方值，从新数组最后位置开始写
        int write = nums.length - 1;
        // 左右指针相遇（逐渐靠拢的过程）之后不再循环
        while (left <= right){
            // 如果原数组的左指针对应的平方值大于右指针，那么往新数组最后位置写入左指针对应的平方值
            if (nums[left] * nums[left] > nums[right] * nums[right]){
                result[write] = nums[left] * nums[left];
                // 左指针右移
                left ++;
                // 移动新数组待写入的位置
                write --;
            }
            else {
                result[write] = nums[right] * nums[right];
                right --;
                write --;
            }
        }
        return result;
    }



}
