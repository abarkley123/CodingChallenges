class Solution {
    
    public void reverseString(char[] s) {
        int i = -1, j = s.length;
        
        while (++i < --j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
