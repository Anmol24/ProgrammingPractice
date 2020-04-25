package com.anmol.service;

public class RemoveDuplicatesII {
    public int removeDuplicates(int[] nums) {
        if(nums ==null || nums.length == 0 ) return 0;
        int prev_ele = nums[0];
        int prev_index = 0;
        int count = 1;
        for(int i = 1;i< nums.length;i++) {
            if(nums[i]== prev_ele) {
                if(count < 2) {
                    count++;
                    prev_index++;
                    nums[prev_index] = nums[i];
                }
            } else {
                prev_ele = nums[i];
                prev_index++;
                count=1;
                nums[prev_index] = nums[i];

            }


        }
        return prev_index+1;
        /*int ptr = 0;
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
                count =1;
                ptr++;
            } else if (nums[i]==nums[i-1] && count <2){
                count++;
                ptr++;
            }
            nums[ptr] = nums[i];
        }
        return ptr+1;*/

        /*int n = nums.length;
        int duplicatesAllowed = 2;
        int start = duplicatesAllowed;
        int end = duplicatesAllowed;
        while (end < n) {
            if (nums[start - duplicatesAllowed] != nums[end]) {
                nums[start++] = nums[end];
            }
            end++;
        }
        return start;*/
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        RemoveDuplicatesII removeDuplicatesII = new RemoveDuplicatesII();
//        System.out.println(removeDuplicatesII.removeDuplicates(new int[] {1,1,1,2,2,2,3}));
        System.out.println(removeDuplicatesII.removeDuplicates(new int[] {1,1,1,2,2,2,2,2,2,3,3,3,4}));
//        System.out.println(removeDuplicatesII.removeDuplicates(new int[] {1,2,3,4,5}));
    }
}
