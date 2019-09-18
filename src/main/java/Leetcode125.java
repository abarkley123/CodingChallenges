import java.util.regex.Pattern;

class Solution {
    
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z0-9]*$");
    
    /** Pattern matching solution - 21ms 37.7mb **/
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
    
    /** Two pointer solution, with one regex check - 19ms 38.7mb **/
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");                                      
        int len = str.length(), i = 0, j = len - 1;
        
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) return false;
        }
        
        return true;
    }
    
    /** An even more concise solution - 23ms 37.7mb **/
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");                                    
        return s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());
    }
}
