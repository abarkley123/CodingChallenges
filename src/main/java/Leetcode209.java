class Solution {
    
    public int minSubArrayLen(int s, int[] nums) {
        int minLength = Integer.MAX_VALUE, j = -1;
        for (int i = 0; i < nums.length; i++) {
            j = i + 1;
            int sum = nums[i];
            
            if (sum >= s) {
                minLength = Math.min(minLength, j - i);
                continue;
            }
            
            while (j < nums.length && sum < s) {
                sum += nums[j++];
                if (sum >= s) {
                    minLength = Math.min(minLength, j - i);
                }
            }
        }
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
