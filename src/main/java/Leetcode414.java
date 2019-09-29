class Solution {
    
    /** check for distinct maxes: 2ms, 36.5MB **/
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        
        if (nums.length < 3) return nums[nums.length - 1];
        else {
            int val = nums[nums.length - 1], index = nums.length - 2, numDistinct = 1;
            while (numDistinct < 3 && index >= 0) {
                if (nums[index] != val) { 
                    numDistinct++;
                    val = nums[index];
                }
                
                index--;
            }

            return numDistinct < 3 ? nums[nums.length - 1] : val;
        }
    }
}
