class Solution {
    
    public int change(int amount, int[] coins) {
        if(coins.length==0 && amount ==0)  return 1;
        if(coins.length==0 && amount !=0)  return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            int num = coins[i];
            for (int j = num; j <= amount; j++) dp[j] += dp[j - num];
        }
        return dp[amount];
    }
}
