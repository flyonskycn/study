package com.flyonsky.sorting;

/**
 * 选择排序
 * @author luowengang
 * @date 2021/6/14 10:03
 */
public class SelectSort {


    public static void main(String[] args) {
        int[] nums = {10,9,8,7,4,1,2,3,5,6};

        sort(nums);

        for(int num : nums){
            System.out.println(num);
        }
    }

    /**
     * 选择排序算法
     * 算法复杂度O(n*n),空间复度O(1)
     * @param nums
     */
    public static void sort(int[] nums){
        int swap = 0;
        for(int i=0; i < nums.length -1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    swap = nums[i];
                    nums[i] = nums[j];
                    nums[j] = swap;
                }
            }
        }
    }
}
