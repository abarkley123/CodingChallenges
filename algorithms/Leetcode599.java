    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ret = new ArrayList<>();
        Map<String, Integer> restaurants = new HashMap<>();
        for (int i = 0; i < list1.length; i++) restaurants.put(list1[i], i);
    
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < list2.length; j++) {
            if (restaurants.containsKey(list2[j])) {
                int diff = j + restaurants.get(list2[j]);
                if (diff < min) {
                    min = diff;
                    ret.clear();
                    ret.add(list2[j]);
                } else if (diff == min) {
                    ret.add(list2[j]);
                }
            }
        }
        
        return ret.stream().toArray(String[]::new);
    }
