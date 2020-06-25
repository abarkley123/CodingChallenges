// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
// https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    
    public String longestPalindrome(String s) {
        int start = 0, end = 0, length = 0;
        if (s == null || (length = s.length()) == 0) return "";
        else if (length == 1) return s;
        
        for (int i = 0; i < length; i++) {
            int len1 = longestPalindrome(s, i, i);
            int len2 = longestPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private int longestPalindrome(String s, int left, int right) {
        int i = left, j = right, len = s.length();
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        
        return j - i - 1;
    }
}
