class Solution {
    
    public char findTheDifference(String s, String t) {
        char ret = 0;
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            if (--arr[c - 'a'] < 0) {
                ret += c;
                break;
            }
        }
        
        return ret;
    }
}
