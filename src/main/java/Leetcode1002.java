    public List<String> commonChars(String[] A) {
        List<String> ret = new ArrayList<>();
        if (A == null || A.length == 0) return ret;
        
        int[][] characters = new int[A.length][26];
        for (int x = 0; x < A.length; x++) {
            for (int y = 0; y < A[x].length(); y++) {
                characters[x][A[x].charAt(y) - 'a']++;
            }
        }
        
        outerloop: for (int i = 0; i < 26; i++) {
            int occurences = characters[0][i];
            for (int j = 1; j < characters.length; j++) {
                occurences = Math.min(occurences, characters[j][i]);
            }
            
            for (int x = 0; x < occurences; x++) {
                ret.add(((char) ('a' + i)) + "");
            }
        }
        
        return ret;
    }
