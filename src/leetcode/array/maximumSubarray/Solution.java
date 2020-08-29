package leetcode.array.maximumSubarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        //my solution
//        int sum = nums[0];
//        int maxSub = nums[0];
//        for(int i = 0; i < nums.length; i++){
//            sum = nums[i];
//            if(sum > maxSub)
//                maxSub = sum;
//            for(int j = i+1; j < nums.length; j++){
//                sum+= nums[j];
//                if(sum > maxSub)
//                    maxSub = sum;
//            }
//        }
//        return maxSub;
        //end my solution

        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < n; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}