class Solution {
    
    /** no dp required - 87% 100% **/
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, profit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }
        
        return profit;
    }
}
