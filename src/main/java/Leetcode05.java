class Solution {
    
    public String longestPalindrome(String s) {
        int i = 0, len = 0;
        if (s == null || (len = s.length()) == 0) return "";
        else if (len == 1) return s;
        
        List<String> dp = new ArrayList<>();
        dp.add("");
        
        while (i < len) {
            getPalindrome(s.substring(i++), dp);
        }
        
        return dp.get(dp.size() - 1);
    }
    
    private void getPalindrome(String s, List<String> dp) {
        if (s.length() <= dp.get(dp.size() - 1).length()) return;
        
        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        outerloop: for (int x = 0; x < len; x++) {
            sb.append(s.charAt(x));
            
            int i = 0, j = x;
            while (i < j) {
                if (sb.charAt(i++) != sb.charAt(j--)) continue outerloop;
            }
            
            if (x + 1 > dp.get(dp.size() - 1).length()) dp.add(sb.toString());
        }
    }
}
