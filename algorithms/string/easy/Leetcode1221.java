// Balanced strings are those who have equal quantity of 'L' and 'R' characters.

// Given a balanced string s split it in the maximum amount of balanced strings.

// Return the maximum amount of splitted balanced strings.

class Solution {
    
    public int balancedStringSplit(String s) {
        int maxSplits = 0, splitCount = 0;
        if (s == null || s.length() == 0) return maxSplits;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'L') splitCount++;
            else if (c == 'R') splitCount--;
            
            if (splitCount == 0) maxSplits++;
        }
        
        return maxSplits;
    }
}

// 0ms 37.5MB. https://leetcode.com/problems/split-a-string-in-balanced-strings/submissions/