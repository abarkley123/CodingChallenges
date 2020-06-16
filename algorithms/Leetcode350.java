    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        
        Arrays.sort(nums2);
        List<Integer> list2 = new ArrayList<>(nums2.length);
        for (int i : nums2) list2.add(i);
    
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            int index = Collections.binarySearch(list2, nums1[i]);
            if (index >= 0) {
                ret.add(list2.remove(index));
            }
        }
        
        return ret.stream().mapToInt(i->i).toArray();
    }
