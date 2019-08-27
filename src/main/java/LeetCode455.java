class Solution {
    
    public int findContentChildren(int[] g, int[] s) {
        int ret = 0;
        Arrays.sort(g); Arrays.sort(s);
        
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                j++; i++; ret++;
            } else j++;
        }
        
        return ret;
    }
}
