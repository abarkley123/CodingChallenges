class Solution {
    
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int ret = 0, i = 0;
        while (i < nums.length - ret - 1) {
            if (nums[i] == nums[i + 1]) {
                ret++;
                nums[i + 1] = Integer.MAX_VALUE;
            } else if (nums[i] == Integer.MAX_VALUE || nums[i + 1] == Integer.MAX_VALUE) {
                sortForNextValue(i, nums);  
                sortForNextValue(i + 1, nums);                  
            } else i++;
        }
        
        return nums.length - ret;
    }
    
    private void sortForNextValue(int i, int[] nums) {
        int j = i;
        while (nums[j] == Integer.MAX_VALUE) j++;
        if (j != i) {
            nums[i] = nums[j];
            nums[j] = Integer.MAX_VALUE;   
        }
    }
}
