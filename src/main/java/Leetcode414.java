class Solution {
    
    /** O(n) three-variable-store: 0ms, 37.4MB **/
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
		
        for (int i = 0; i < nums.length; i++) {
		// if we find a new max, we must shift first -> second, and second -> third.
            if (nums[i] > first) {
                long tmp = first;
                long tmp2 = second;
                first = nums[i];
                second = tmp;
                third = tmp2;
		// otherwise if we find a secondary max, we must shift the original second -> third.
            } else if (nums[i] > second && nums[i] != first) {
                long tmp = second;
                second = nums[i];
                third = tmp;
		// otherwise if we find a 'unique' third maximum, assign it to the third variable.
            } else if (nums[i] > third && nums[i] != second && nums[i] != first) third = nums[i];
        }
        
		// if we found fewer than 3 distinct values, return the largest. Otherwise return as normal.
        return (int) (third == Long.MIN_VALUE ? first : third);
    }
    
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
