class Solution {
    
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        else if (intervals == null || intervals.length == 0) return new int[][]{};
        
        List<int[]> l = new ArrayList<>();
        List<int[]> ret = new ArrayList<>(intervals.length);
        for (int[] arr : intervals) ret.add(arr);
        
        int counter = 0;
        int[] curr = ret.remove(0);
        while (!ret.isEmpty()) {
            if (counter >= ret.size()) {
                l.add(curr);
                
                if (ret.size() > 1) {
                    curr = ret.remove(0);
                    counter = 0;
                } else {
                    l.add(ret.remove(0));
                    break;
                }
            }
            int[] tmp = ret.get(counter);
            if ((curr[0] <= tmp[0] && curr[1] >= tmp[1]) 
                || (tmp[1] <= curr[1] && tmp[1] >= curr[0])
                || (tmp[0] <= curr[1] && tmp[0] >= curr[0])
                || (tmp[0] <= curr[0] && tmp[1] >= curr[1])) {
                ret.remove(counter);
                curr[0] = Math.min(curr[0], tmp[0]);
                curr[1] = Math.max(curr[1], tmp[1]);
                if (ret.isEmpty()) l.add(curr);
                counter = 0;
            } else counter++;
        }
        
        return l.toArray(new int[0][]);
    }
}
