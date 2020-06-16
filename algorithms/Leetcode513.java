class Solution {
    
    int maxLevel = -1;
    int leftMostValue = 0;
    
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 0);
        return leftMostValue;
    }
    
    public void findBottomLeftValue(TreeNode root, int depth) {
        if (root==null) return;
        if (depth > maxLevel) {
            maxLevel = depth;
            leftMostValue = root.val;
        }
        
        findBottomLeftValue(root.left, depth + 1);
        findBottomLeftValue(root.right, depth + 1);
    }
}
