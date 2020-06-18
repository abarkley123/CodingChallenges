// Given an array nums. 
// We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
// Return the running sum of nums.

class Solution {
    
    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] runningSum = new int[nums.length];
        
        runningSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            runningSum[i] = nums[i] + runningSum[i - 1];
        }
        
        return runningSum;
    }
}

// 0ms (100%) 39.2MB (100%).