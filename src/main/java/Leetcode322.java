class Solution {
    
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        long[] dp = new long[amount+1];
        for (int i = 1; i <= amount; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int c : coins) {
                dp[i] = Math.min(dp[i], i >= c ? dp[i - c] + 1 : Integer.MAX_VALUE);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
    }
}
