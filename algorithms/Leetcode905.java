    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 != 0) {
                if (A[j] % 2 != 0) {
                    j--;
                    continue;
                }
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            } 
            i++;
        }
        return A;
    }
