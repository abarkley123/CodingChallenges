// There are two sorted arrays nums1 and nums2 of size m and n respectively.
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
// You may assume nums1 and nums2 cannot be both empty.
// https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution {
    
    /** Using streams **/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int [] arr = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray();
        
        return len % 2 == 0 ? (arr[len/2] + arr[len/2 - 1])/2. : arr[len / 2];
    }
    
    /** Using conventional Java **/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, len = nums1.length + nums2.length;
        int [] arr = new int[len];
        
        for (i = 0; i < nums1.length; i++) arr[i] = nums1[i];
        for (int j = 0; j < nums2.length; j++) arr[i + j] = nums2[j];
      
        Arrays.sort(arr);
        return len % 2 == 0 ? (arr[len/2] + arr[len/2 - 1])/2. : arr[len / 2];
    }
}
