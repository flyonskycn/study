package com.flyonsky.sorting;

/**
 * 希尔排序
 * @author luowengang
 * @date 2021/6/14 10:46
 */
public class HillSort {

    public static void main(String[] args) {
        int[] nums = {10,9,8,7,4,1,2,3,5,6};

        sort(nums);

        for(int num : nums){
            System.out.println(num);
        }
    }

    /**
     * 希尔排序
     * 时间复杂度O(n*n),空间复杂度O(1)
     * @param nums
     */
    public static void sort(int[] nums){
        int swap = 0;

        int hill = 1;
        while(hill < nums.length/3){
            hill = 3 * hill + 1;
        }

        while (hill >= 1){
            for(int i = hill; i < nums.length; i++){
                for(int j = i; j >= hill; j -= hill){
                    if(nums[j] < nums[j - hill]){
                        swap = nums[j];
                        nums[j] = nums[j - hill];
                        nums[j - hill] = swap;
                    }
                }
            }
            hill = hill / 3;
        }
    }
}
