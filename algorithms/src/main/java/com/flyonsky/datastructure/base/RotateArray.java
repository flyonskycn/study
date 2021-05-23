package com.flyonsky.datastructure.base;

/**
 * @author luowengang
 * @date 2021/5/23 10:03
 */
public class RotateArray {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

//        int[] nums = {-1,-100,3,99};
//        int k = 2;

        rotate(nums,3);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     *
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * @param nums
     * @param k
     * @return
     */
    public static void rotate(int[] nums, int k){
        if(nums != null
                && nums.length > k
                && k > 0){
            int nIndex = 0;
            int oldIndex = 0;
            int changCount = nums.length/k;
            if(nums.length % k > 0){
                changCount++;
            }

            int switchOld = 0;
            int switchNew = 0;
            for(int i=0; i < k; i++){
                oldIndex = nums.length - 1 - i;
                switchOld = nums[oldIndex];

                for(int j = 1;j <= changCount; j++){
                    nIndex = (oldIndex + k) % nums.length;
                    switchNew = nums[nIndex];
                    nums[nIndex] = switchOld;

                    /** 新值为下一次的旧值 **/
                    oldIndex = nIndex;
                    switchOld = switchNew;
                }
            }
        }
    }
}
