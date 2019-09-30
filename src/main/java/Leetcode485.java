class Solution {
    
    /** Two int stores - 2ms (99.65%), 38.3MB (100%) **/
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, curr = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                curr++;
            } else if (nums[i] == 0) {
                max = Math.max(max, curr);
                curr = 0;
            }
        }
        
        return Math.max(max, curr);
    }
}
