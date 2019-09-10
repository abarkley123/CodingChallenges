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
