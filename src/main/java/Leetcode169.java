class Solution {
    
    /** use hashmap getOrDefault - 13ms 40.9mb **/
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) >= nums.length/2 + 1) return i;
        }
        
        return 0;
    }
    
    /** Use array sorting - 3ms 41.4mb **/
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && ++counter >= nums.length/2 + 1) return nums[i];
            else if (nums[i] != nums[i - 1]) counter = 1;
        }
        
        return nums[0];
    }
}
