    public int[] shortestToChar(String S, char C) {
        List<Integer> map = new ArrayList<>();
        
        int n = S.length();
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C) map.add(i);
        }
        
        int[] ret = new int[n];
        for (int x = 0; x < n; x++) {
            int lowestDiff = Integer.MAX_VALUE;
            
            for (int y = 0; y < map.size(); y++) {
                lowestDiff = Math.min(lowestDiff, Math.abs(map.get(y) - x));
            }
            
            ret[x] = lowestDiff;
        }
        
        return ret;
    }
