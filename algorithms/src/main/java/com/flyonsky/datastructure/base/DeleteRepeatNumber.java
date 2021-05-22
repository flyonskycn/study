package com.flyonsky.datastructure.base;

import java.util.Objects;

/**
 * 删除已有序数组中的重复元素，只保留一个，并返回新的数组长度
 * 要求：原地删除，在空间复杂度为O(1);
 * @author luowengang
 * @date 2021/5/22
 */
public class DeleteRepeatNumber {

    /**
     * 删除已有序数组中的重复元素，只保留一个，并返回新的数组长度
     * 要求：原地删除，在空间复杂度为O(1);时间复杂度为O(n)
     * @param nums
     * @return
     */
    public static int delteRepeat(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int len = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[len] != nums[i]){
                nums[++len] = nums[i];
            }
        }
        return ++len;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,2,3,4,4,5,5,6,7,8,8,8,9};
//        int[] nums = {0};

        int len = delteRepeat(nums);
        System.out.println(len);
        for(int i=0;i<len;i++){
            System.out.println(nums[i]);
        }
    }
}
