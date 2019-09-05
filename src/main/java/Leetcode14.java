class Solution {
    
    public String longestCommonPrefix(String[] strs) {
        String ret = "";
        if (strs == null || strs.length == 0) return ret;
        
        outerloop: for (int i = 0; i < strs[0].length(); i++) {
            for (String s : strs) {
                if (i == s.length() || s.charAt(i) != strs[0].charAt(i)) break outerloop;
            }    
            
            ret += strs[0].charAt(i);
        }
        
        return ret;
    }
}
