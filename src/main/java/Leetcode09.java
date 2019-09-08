class Solution {
    
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        
        Stack<Character> st = new Stack<>();
        char[] arr = Integer.toString(x).toCharArray();
        
        for (int i = 0; i < arr.length/2; i++) {
            st.push(arr[i]);
        }
        
        for (int j = arr.length - arr.length/2; j < arr.length; j++) {
            if (arr[j] != st.pop()) return false;
        }
        
        return true;
    }
}
