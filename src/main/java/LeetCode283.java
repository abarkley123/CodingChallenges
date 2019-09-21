class Solution {
    
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
}
