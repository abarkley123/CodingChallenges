class Solution {
    
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        
        int[] arr2 = new int[26];
        for (char c : t.toCharArray()) {
            arr2[c - 'a']++;
        }
        
        char ret = 'a';
        for (int i = 0; i < 26; i++) {
            if (arr2[i] != arr[i]) {
                ret += i;
                break;
            }
        }
        
        return ret;
    }
}
