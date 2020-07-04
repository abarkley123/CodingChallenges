/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// minimum absolute distance - https://leetcode.com/problems/minimum-absolute-difference-in-bst/
Class Solution {
    
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        Collections.sort(list);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) minDiff = Math.min(minDiff, list.get(i) - list.get(i - 1));
        
        return minDiff;
    }
    
    public void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;
        
        list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);
    }
}
