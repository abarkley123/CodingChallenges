class Solution {
    
    /** O(N^2) soln - 1ms (77%) 36.3 MB (100%)
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int counter = 0;
        for (int i = 0; i < arr2.length; i++) { 
            int j = counter - 1;
            while (++j < arr1.length) {
                if (arr2[i] == arr1[j]) {
                    int temp = arr1[counter];
                    arr1[counter++] = arr2[i];
                    arr1[j] = temp;
                }
            }
        }
        
        Arrays.sort(arr1, counter, arr1.length);
        return arr1;
    }
}
