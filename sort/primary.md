# 入门算法记录

## 二分查找

题目：给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

示例 1:

```
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
```


示例 2:

```
输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
```


提示：

```
你可以假设 nums 中的所有元素是不重复的。
n 将在 [1, 10000]之间。
nums 的每个元素都将在 [-9999, 9999]之间。
```

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-search

### **思路：**

二分法，本题给出的已排序的数组，思路是先找出中间索引对应的值和目标值比较，等于目标值就代表找到，如果大于目标值 缩短右边界的值，小于就缩短左边界的值



### **代码：**

```java
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
```



## 第一个错误的版本

你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。

假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。

你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。



示例 1：

```
输入：n = 5, bad = 4
输出：4
解释：
调用 isBadVersion(3) -> false 
调用 isBadVersion(5) -> true 
调用 isBadVersion(4) -> true
所以，4 是第一个错误的版本。
```


示例 2：

```
输入：n = 1, bad = 1
输出：1
```

**提示：**

- `1 <= bad <= n <= 231 - 1`

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-bad-version

### **思路**：

<u>本题也可以继续用二分查询的方法执行</u>

二分查找的01模型：

也就是从 000000000000111111111111 中找到第一个1。

**伪代码如下**：

下界：left, 上界:right

```java
        while (left<right){
            mid = left + ((right - left) >> 1);
            if(isBadVersion(mid))
                right = mid;
            else
                left = mid + 1;
        }   
```

当 left == right 时，也就是说left-1是不ok的

因为 right  始终是1，而left只可能从分界的位置变成1，之后left就不可能发生变化了，随后只能是right逐渐变小，最后left与right相遇。

参阅：https://leetcode-cn.com/problems/first-bad-version/solution/ba-chu-2gai-cheng-yi-wei-ran-hou-jiu-gan-84ln/


### **代码：**

```java
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n, mid = 0;        
        while (left<right){
            mid = left + ((right - left) >> 1);
            if(isBadVersion(mid))
                right = mid;
            else
                left = mid + 1;
        }         
        return left;
    }
}
```

## 有序数组的平方

给你一个按 **非递减顺序** 排序的整数数组 `nums`，返回 **每个数字的平方** 组成的新数组，要求也按 **非递减顺序** 排序。

示例 1：

```
输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]
```


示例 2：

```
输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]
```


提示：

```
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 已按 非递减顺序 排序
```

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array

### 思路：

数组是有序的，就是可能存在负数，而负数平方后可能比小的正数大，但是因为数组时有序的，所以较大的平方数只可能存在两端，这样我们双指针求解时，一端指向头部，一端指向尾部，只需要比较他们的大小就可以将数组排序成功，时间复杂度为o（n）；



### 答案：

```java
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
```