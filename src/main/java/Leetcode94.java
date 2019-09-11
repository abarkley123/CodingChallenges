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

/** recursive implementation **/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        
        dfs(root, ret);
        
        return ret;
    }    
    
    private void dfs(TreeNode root, List<Integer> ret) {
        if (root == null) return;
        
        dfs(root.left, ret);
        ret.add(root.val);
        dfs(root.right, ret);
    }
    
** iterative implementation **/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        
        if (root != null) { 
            Stack<TreeNode> st = new Stack<>();
            TreeNode curr = root;
            
            while (curr != null || !st.empty()) {
                while (curr != null) {
                    st.push(curr);
                    curr = curr.left;
                }
                
                curr = st.pop();
                ret.add(curr.val);
                curr = curr.right;
            }
        }
                
        return ret;
    }    
}
