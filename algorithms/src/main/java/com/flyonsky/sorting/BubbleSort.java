package com.flyonsky.sorting;

/**
 * @author luowengang
 * @date 2021/6/14 17:18
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {10,9,8,7,4,1,2,3,5,6};

        sort(nums);

        for(int num : nums){
            System.out.println(num);
        }
    }

    /**
     * 冒泡排序
     * 时间复杂度为O(n*n),空间复杂度为O(1)
     *
     * @param nums
     */
    public static void sort(int[] nums){
        int swap = 0;
        for(int i = 0; i < nums.length -1; i++){
            for(int j = 0; j<nums.length-i -1; j++){
                if(nums[j] > nums[j+1]){
                    swap = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = swap;
                }
            }
        }
    }
}
