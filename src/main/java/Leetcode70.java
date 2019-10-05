class Solution {
    
    /** Simple dp soln - 0ms (100%), 32.7MB (5.76%) **/ 
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    /** Alt solution without using array - 0ms, 32.8MB **/
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int first = 1, second = 2, third = 2;
        
        for (int i = 3; i <= n; i++) {
            third = first + second;
            int temp = second;
            second = third;
            first = temp;
        }
        
        return third;
    }
}
