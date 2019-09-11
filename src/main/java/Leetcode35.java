class Solution {
    
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        
        int i = 0, ret = -1;
        while (nums[i] < target) {
            if (i >= nums.length - 1) {
                i++;
                break;
            }
            if (nums[i] < target) {
                i++;
            } else if (nums[i] == target) {
                ret = i;
                break;
            } 
        }
        
        return ret >= 0 ? ret : i;
    }
}
