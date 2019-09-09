class Solution {
    
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int ret = 0, i = 0;
        while (i < nums.length - ret - 1) {
            if (nums[i] == nums[i + 1]) {
                ret++;
                nums[i + 1] = Integer.MAX_VALUE;
                Arrays.sort(nums);
            } else i++;
        }
        
        return nums.length - ret;
    }
}
