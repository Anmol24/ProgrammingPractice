package com.anmol.service;

public class PartitionEqualsSubsetSum {

    public boolean canPartitionRecursive(int[] nums) {
        int total = 0;
        for(int i : nums) {
            total+=i;
        }
        if(total%2!=0) {
            return false;
        }

        return canPartitionRecursive(nums, 0, 0, total);
    }

    private boolean canPartitionRecursive(int[] nums, int index, int sum, int total) {
        if(sum*2== total) {
            return true;
        }
        if(sum > total/2 || index >= nums.length) {
            return false;
        }
        // case 1 when we have to include the current element in the sum, case 2 when it is not included

        return canPartitionRecursive(nums, index+1, sum, total) ||
                canPartitionRecursive(nums, index+1, sum+nums[index], total);

    }


    public static void main(String[] args) {
        PartitionEqualsSubsetSum subsetSum = new PartitionEqualsSubsetSum();
        subsetSum.canPartitionRecursive(new int[]{1,2,3,4});
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum+=i;
        }
        if(sum%2!=0)
            return false;

        sum = sum/2;

        boolean[][] result = new boolean[nums.length+1][sum+1];
        for(int i =1;i<=nums.length;i++) {
            result[i][0] = true;
        }

        for(int i = 1;i<=nums.length;i++) {
            for(int j = 1;j<=sum;j++) {
                if(j<nums[i-1]) {
                    result[i][j] = result[i-1][j];
                } else {
                    result[i][j] = result[i-1][j] || result[i-1][j-nums[i-1]];
                }
            }
        }
        return result[nums.length][sum];
    }
}
