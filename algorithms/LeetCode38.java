//Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. 
// You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.
// https://leetcode.com/problems/count-and-say/ 

class Solution {
    
    public String countAndSay(int n) {
        if (n <= 0) return "";
        
        return countAndSay(n, 1, "1");
    }
    
    private String countAndSay(int target, int current, String s) {
        if (current >= target) {
            return s;
        }
        
        int i = 0, j = 0, len = s.length();
        StringBuilder sb = new StringBuilder();
        while (i < len) {
            if (j < len && s.charAt(i) == s.charAt(j)) {
                j++;
            } else {
                if (j - 1 == i) {
                    sb.append(1);
                } else {
                    sb.append(j - i);
                }
                
                sb.append(s.charAt(i));
                i = j;
            }
        }
        
        return countAndSay(target, current + 1, sb.toString());
    }
}
