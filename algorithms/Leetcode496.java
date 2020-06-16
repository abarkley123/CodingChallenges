    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ret = new int[nums1.length];
        
        Map<Integer, Integer> positions = new HashMap<>();
        for (int x = 0; x < nums2.length; x++) positions.put(nums2[x], x);
        
        outerloop: for (int i = 0; i < nums1.length; i++) {
            int number = nums1[i];
        
            if (positions.get(number) != null) {    
                int j = positions.get(number) - 1;
                
                while (++j < nums2.length) {
                    if (nums2[j] > number) {
                        ret[i] = nums2[j];
                        continue outerloop;
                    }
                }
            }
            
            ret[i] = -1;
        }
        
        return ret;
    }
