import java.util.regex.Pattern;

class Solution {
    
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z0-9]*$");
    
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int len = s.length(), i = 0, j = len - 1, tmp = 0;
        
        while (i < j) {
            if (!pattern.matcher(String.valueOf(str.charAt(i))).matches()) {
                i++;
                continue;
            } else if (!pattern.matcher(String.valueOf(str.charAt(j))).matches()) {
                j--;
                continue;
            }
            
            if (str.charAt(i++) != str.charAt(j--)) return false;
        }
        
        return true;
    }
}
