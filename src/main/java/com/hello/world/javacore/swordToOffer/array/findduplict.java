package com.hello.world.javacore.swordToOffer.array;

/**
 * @author xing
 */
public class findduplict {
    public static void main(String[] args) {
        int[] nums = {1,2,0,4,3,2};
        int length = nums.length;
        int[] duplication = {2};
        boolean res = duplicate(nums,length,duplication);
        System.out.println(res);
    }
    private static boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length< 0){
            return false;
        }
        for (int i =0 ;i< length;i++){
            while (nums[i] != i){
                if (nums[i] == nums[nums[i]]){
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums,i,nums[i]);
            }
        }
        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
