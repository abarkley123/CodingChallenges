class Solution {
    
    /** Dynamic programming, using G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0) - 0ms, 33.1MB **/
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        
        return dp[n];
    }
}
