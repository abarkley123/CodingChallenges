class Solution {
    
    /** Use int to determine next move - 5ms (93.27%) 42.7MB (100%) **/
    public int maxTurbulenceSize(int[] A) {
        if (A == null || A.length == 0) return 0;
        else if (A.length == 1) return 1;
        
        int i = -1, last = -1, max = 1, curr = 1;
        while (++i < A.length - 1) {
            if ((last == 0 || last == -1 || curr < 2) && A[i + 1] > A[i]) {
                curr++;
                last = 1;
            } else if ((last == 1 || last == -1) && A[i + 1] < A[i]) {
                curr++;
                last = 0;
            } else {
                max = Math.max(max, curr);
                curr = 1;
                last = -1;
                if (A[i + 1] != A[i]) i--;
            }
        }
        
        return Math.max(max, curr);
    }
}
