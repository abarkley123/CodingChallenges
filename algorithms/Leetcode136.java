    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int ret = -1;
        Set<Integer> map = new HashSet<>();
        
        for (int i : nums) {
            if (!map.add(i)) map.remove(i);
        }
        
        return map.iterator().next();
    }
