// Height checker - https://leetcode.com/problems/height-checker/

class Solution {
    
    public int heightChecker(int[] heights) {
        int[] indexes = new int[heights.length];
        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = heights.length - 1; j > i; j--) {
                if (heights[i] > heights[j]) {
                    int temp = heights[i];
                    heights[i] = heights[j];
                    heights[j] = temp;
                    indexes[i] = 1;
                    indexes[j] = 1;
                }
            }
        }
        
        return Arrays.stream(indexes).sum();
    }
}
