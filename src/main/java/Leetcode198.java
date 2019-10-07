class Solution {
    
    /** Dynamic programm bottom-up: 0ms (100%), 34.3MB (100%) **/
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);

        int max = dp[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i -1]);
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}
