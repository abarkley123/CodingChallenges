class Solution {
    
    public void moveZeroes(int[] nums) {
        int numZeroes = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            
            System.out.println("i " + i + " " + nums[i]);
            if (nums[i] == 0 && i < nums.length - 1) {
                if (nums[i + 1] != 0) {
                    while (j < nums.length - 1 && nums[j + 1] != 0) {
                        nums[j] = nums[j + 1];
                        nums[j++ + 1] = 0;
                    }
                    i = j - 1;
                } else {
                    if (i + 1 <= nums.length - 1) {
                        while (nums[i + 2] == 0) i++;
                        nums[i] = nums[i + 2];
                        nums[i + 2] = 0;
                        // i += 1;
                    
                    }
                }
            }
        }
    }
}
