import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:

 The solution set must not contain duplicate triplets.

 Example:

 Given array nums = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 */
public class ThreeSumLeetcode {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    /**
     * Idea is to sort the list and then run 2 loops.
     * in the first loop keep the index fixed for that iteration say i index and for the second loop
     * keep 2 variables i+1 and length of the array. now you have 3 indexes. You can compare the sum of these 3 elements and
     * get the target result. If the sum is greater than 0 then move the last index k as array is sorted and you have to get sum as 0.
     * If sum is less than 0 then increase j.
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length <=2) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i< nums.length;i++) {
            int j = i+1;
            int k = nums.length-1;
            while(j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum ==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    if(!result.contains(temp)) {
                        result.add(temp);
                    }
                }
                if(sum<0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;

    }
}
