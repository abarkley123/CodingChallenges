class Solution {
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] arr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) arr[nums[i]] = 1;
        
        List<Integer> ret = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) if (arr[j] == 0 && j != 0) ret.add(j);
        
        return ret;
    }
}
