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
    
    public int minDiffInBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        minDiff(root, values);
        
        int min = Integer.MAX_VALUE, i = -1;
        Collections.sort(values);
        while (++i < values.size() - 1) {
            min = Math.min(min, values.get(i + 1) - values.get(i));
        }
                                                                   
        return min;
    }
    
    public void minDiff(TreeNode root, List<Integer> values) {
        if (root != null) {
            
            values.add(root.val);
            minDiff(root.left, values);
            minDiff(root.right, values);
        }
    }
}
