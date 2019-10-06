class Solution {
    
    /** O(N^2) solution: 70ms (5.44%), 40.1MB (100%) **/
    /** Note: Using Integer and a comparator to sort likely incurs a heavy peformance penalty **/
    public String[] findRelativeRanks(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = nums[i];
        Arrays.sort(arr, Collections.reverseOrder());
        
        final int len = nums.length;
        String[] ret = new String[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] == arr[0]) ret[i] = "Gold Medal";
            else if (nums[i] == arr[1]) ret[i] = "Silver Medal"; 
            else if (nums[i] == arr[2]) ret[i] = "Bronze Medal";
            else {
                int j = 0;
                while (arr[j] != nums[i]) j++;
                ret[i] = Integer.toString(j + 1);   
            }
        }
        
        return ret;
    }
    
    /** Same solution without comparator - 32ms (33%), 38.3MB (100%) **/
    public String[] findRelativeRanks(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = nums[i];
        Arrays.sort(arr);
        
        final int len = nums.length;
        String[] ret = new String[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] == arr[arr.length - 1]) ret[i] = "Gold Medal";
            else if (nums[i] == arr[arr.length - 2]) ret[i] = "Silver Medal"; 
            else if (nums[i] == arr[arr.length - 3]) ret[i] = "Bronze Medal";
            else {
                int j = arr.length - 4;
                while (arr[j] != nums[i]) j--;
                ret[i] = Integer.toString(arr.length - j);   
            }
        }
        
        return ret;
    }
}
