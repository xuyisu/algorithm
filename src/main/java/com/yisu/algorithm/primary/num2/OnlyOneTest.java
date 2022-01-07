package com.yisu.algorithm.primary.num2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuyisu
 * @description 136. 只出现一次的数字
 * @date 2020/5/14
 */
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
public class OnlyOneTest {

    // 使用map 处理
    public static int singleNumber(int[] nums) {
        AtomicInteger res= new AtomicInteger();
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(null!=map.get(nums[i])){
                map.put(nums[i],(map.get(nums[i]).intValue())+1);
            }else{
                map.put(nums[i],1);
            }
        }
        map.forEach((key, value) -> {
            if(value==1) {
                res.set(key);
                return;
            }
        });
        return res.intValue();
    }

    //使用异或处理
    public static int singleNumber2(int[] nums) {
        int res=nums[0];
        for (int i = 1; i < nums.length; i++) {
             res^=nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,2,3,4};
        System.out.println(singleNumber2(arr));
    }


}
