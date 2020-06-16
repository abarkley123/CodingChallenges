class Solution {
    
    /** Store even-numbers sum in int - 4ms (97.69%) 58 MB (100%) **/
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        for (int x = 0; x < A.length; x++) if (A[x] % 2 == 0) sum += A[x];
        
        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (A[queries[i][1]] % 2 == 0) {
                if ((A[queries[i][1]] + queries[i][0]) % 2 == 0) sum += queries[i][0];
                else sum -= A[queries[i][1]];
            } else if ((A[queries[i][1]] + queries[i][0]) % 2 == 0) sum += A[queries[i][1]] + queries[i][0];

            ret[i] = sum;
            A[queries[i][1]] += queries[i][0];
        }
        
        return ret;
    }
    
    /** Interesting note: 
     *  Using stream pipeline i.e, sum = Arrays.stream(A).filter(num -> num % 2 == 0).sum() 
     *  takes 40ms longer (10x slower than the submission time for the above soln)!
     **/
}
