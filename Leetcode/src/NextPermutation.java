package com.anmol.service;

/**
 * The steps to solve this problem:
 * 1) scan from right to left, find the first element that is less than its previous one.
 *
 * 4 5 6 3 2 1
 *   |
 *   p
 * 2) scan from right to left, find the first element that is greater than p.
 *
 * 4 5 6 3 2 1
 *     |
 *     q
 * 3) swap p and q
 *
 * 4 5 6 3 2 1
 * swap
 * 4 6 5 3 2 1
 * 4) reverse elements [p+1, nums.length]
 *
 * 4 6 1 2 3 5
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(nums == null|| nums.length<=1) return;

        int p1 = nums.length-1;
        while(p1>0) {
            if(nums[p1]>nums[p1-1]) {
                p1--;
                break;
            }
            p1--;
        }
        if(p1>=0) {
            int p2 = nums.length-1;
            while(p2>0 && nums[p1]>=nums[p2]) {
                p2--;
            }
            if(p1 == 0 && p2 == 0) {
                reverse(nums, p1);
                return;
            }
            swap(nums,p1,p2);

        }
        reverse(nums, p1+1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9,8,6,3,2,1};
        NextPermutation permutation = new NextPermutation();
        permutation.nextPermutation(nums);
        for(int i : nums){
            System.out.println(i);
        }

    }
}
