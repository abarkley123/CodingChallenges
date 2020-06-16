/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    /** recursive solution w/ instance variable: 0ms (100%) 36.5MB (100%) **/
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }
    
    public int dfs(TreeNode root, boolean shouldAdd) {
        if (root == null) {
            return sum;
        }
    
        if (root.left == null && root.right == null && shouldAdd) sum += root.val;
        dfs(root.left, true);
        dfs(root.right, false);
        
        return sum;
    }
}
