package main.java;

public class Leetcode188 {

        public int maxProfit(int k, int[] prices) {
            int ret = 0;
            if (k == 0 || prices == null || prices.length == 0) return ret;

            int n = prices.length;

            if (k >=  n/2) {
                int pro = 0;
                for (int i = 1; i < n; i++) {
                    if (prices[i] > prices[i-1])
                        pro += prices[i] - prices[i-1];
                }
                return pro;
            }

            int[][] dp = new int[k+1][prices.length + 1];

            for (int i = 1; i <= k; i++) {
                int tmpMax = Integer.MIN_VALUE;
                for (int j = 1; j <= prices.length; j++) {
                    dp[i][j] = Math.max(dp[i][j - 1], tmpMax + prices[j - 1]);
                    tmpMax = Math.max(tmpMax, dp[i - 1][j - 1] - prices[j - 1]);
                }
            }
            return dp[k][prices.length];
        }
}
