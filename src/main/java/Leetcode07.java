class Solution {
    
    public int reverse(int x) {
        if (x == 0) return x;
        
        String sb = x < 0 ? "-" : "";
        int start = x < 0 ? 1 : 0, charsAdded = 0;
        String s = Integer.toString(x).substring(start);
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (charsAdded == 0 && s.charAt(i) != '0' || charsAdded > 0) {
                charsAdded++;
                sb += s.charAt(i);
            } 
        }
        
        double d = Double.parseDouble(sb);
        return Math.abs(d) > Integer.MAX_VALUE ? 0 : (int) d;
    }
}
