// move zeroes - https://leetcode.com/problems/move-zeroes/

class Solution {
    
    /** O(n^2) solution - 13ms 38.8mb **/
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int j = i;
                while (j <= nums.length - 1 && nums[j] == 0) j++;
                if (j <= nums.length - 1) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                } else break;
            }
        }
    }
    
    /** O(n) solution - 0ms 36.3mb **/
    public void moveZeroes(int[] nums) {
        int i = 0, numZeroes = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) numZeroes++;
            else nums[i - numZeroes] = nums[i];
        }
        
        Arrays.fill(nums, nums.length - numZeroes, nums.length, 0);
    }
}
