package com.flyonsky.datastructure.base;

/**
 * @author luowengang
 * @date 2021/5/23 10:03
 */
public class RotateArray {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
//        int[] nums = {1,2};
//        int k = 2;

//        int[] nums = {-1,-100,3,99};
//        int k = 2;

//        rotate(nums,k);
        rotateInPlace(nums, k);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    /**
     * 拷贝法：
     * 1:将原拷被到一个新数组。
     * 2:计算旧数组下标计算出移动后的下标，并填充值
     *
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     *
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 时间复杂度O(n)，空间复杂度O(n)
     * @param nums
     * @param k
     * @return
     */
    public static void rotate(int[] nums, int k){
        if(nums != null
                && k > 0){
            int newIndex = 0;
            int[] tmpNums = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                tmpNums[i] = nums[i];
            }

            for(int i = 0;i<nums.length;i++){
                newIndex = (i + k) % nums.length;
                nums[newIndex] = tmpNums[i];
            }
        }
    }

    /**
     * 三次反转法：
     * 第一步：将[0,length-k-1]之间的数据反转
     * 第二步：将[length-k,length-1]之间的反转
     * 第三步：将[0,length-1]之间的数组反转
     *
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     *
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 时间复杂度O(k*n)，空间复杂度O(1)
     * @param nums
     * @param k
     * @return
     */
    public static void rotateInPlace(int[] nums,int k){
        if(nums != null && k % nums.length > 0){
            k = k % nums.length;
            int resIndex = nums.length - k -1;
            int midIndex = (resIndex) / 2 + (resIndex) % 2;
            int swap = 0;
            for(int i = 0; i< midIndex; i++){
                swap = nums[i];
                nums[i] = nums[resIndex - i];
                nums[resIndex - i] = swap;
            }

            midIndex = k / 2 + k % 2;

            for(int i = 0; i< midIndex; i++){
                swap = nums[nums.length - k + i];
                nums[nums.length - k + i] = nums[nums.length -1 - i];
                nums[nums.length -1 - i] = swap;
            }

            midIndex = (nums.length) / 2 + (nums.length) % 2;

            for(int i = 0; i< midIndex; i++){
                swap = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = swap;
            }
        }
    }
}
