class MagicDictionary {

    private List<String> dict;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.dict = new ArrayList<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) this.dict.add(s);
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (String s : dict) {
            int diffs = 0, len = word.length();
            
            if (len != s.length()) continue;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != word.charAt(i)) diffs++;
            }
            
            if (diffs == 1) return true;
        }
        
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
