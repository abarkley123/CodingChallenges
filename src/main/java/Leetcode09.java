class Solution {
    
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        
        char[] arr = Integer.toString(x).toCharArray();
        
        int i = 0, j = arr.length - 1;
        while (i <= arr.length/2 && j >= arr.length/2) {
            if (arr[i++] != arr[j--]) return false;
        }
        
        return true;
    }
}
