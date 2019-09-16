    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        
        q1.offer(p);
        q2.offer(q);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            
            if (n1 == null && n2 == null) continue;
            else if ((n1 == null && n2 != null) || (n1 != null && n2 == null) 
                     || (n1 != null && n2 != null && n1.val != n2.val)) return false;
            
            q1.offer(n1.left);
            q1.offer(n1.right);
            q2.offer(n2.left);
            q2.offer(n2.right);
        }
        
        return q1.isEmpty() && q2.isEmpty();
    }
