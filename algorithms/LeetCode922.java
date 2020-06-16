class Solution {
    
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) return A;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == i % 2) continue;
            int j = i;
            
            while (++j < A.length) {
                if (A[j] % 2 == i % 2) {
                    swap(A, i, j);
                    break;
                }
            }
        }
        
        
        return A;
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
