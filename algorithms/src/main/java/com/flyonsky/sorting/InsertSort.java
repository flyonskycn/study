package com.flyonsky.sorting;

/**
 * 插入排序
 * @author luowengang
 * @date 2021/6/14 10:19
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {10,9,8,7,4,1,2,3,5,6};

        sort(nums);

        for(int num : nums){
            System.out.println(num);
        }
    }

    /**
     * 插入排序
     * 时间复杂度O(n*n),空间复杂度O(1)
     * @param nums
     */
    public static void sort(int[] nums){
        int swap = 0;
        for(int i=1; i<nums.length; i++){
            for(int j = i; j>0; j--){
                if(nums[j] < nums[j-1]){
                    swap = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = swap;
                }
            }
        }
    }
}
