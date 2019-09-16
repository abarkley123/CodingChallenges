/** Breadth first search: 0ms, 34.1MB **/    
public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            
            if (n1 == null && n2 == null) continue;
            else if ((n1 == null && n2 != null) || (n1 != null && n2 == null) 
                     || (n1 != null && n2 != null && n1.val != n2.val)) return false;
            
            queue.offer(n1.left);
            queue.offer(n2.left);
            queue.offer(n1.right);
            queue.offer(n2.right);
        }
        
        return queue.isEmpty();
    }
