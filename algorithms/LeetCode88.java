class Solution {
    
    /** Concise solution: 1ms **/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i - m < n; i++) {
            nums1[i] = nums2[i - m];
        }
        
        Arrays.sort(nums1);
    }
    
    /** Alternative solution: In place modify array - 0ms **/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length - 1, i = m - 1, j = n - 1;
        
        while ((i >= 0 && j >= 0) || (i < 0 && j >= 0)) {
            if (j >= 0 && i < 0) nums1[k--] = nums2[j--];
            else if (nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
    }
}
