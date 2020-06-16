    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ret = new ArrayList<>();
        if (left < 0 || left > right) return ret;
        
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) ret.add(i);
        }
        
        return ret;
    }
    
    public boolean isSelfDividing(int num) {
        char[] ch = Integer.toString(num).toCharArray();
        for (char c : ch) {
            int n = c - '0';
            if (n == 0 || num % n != 0) return false;
        }
        
        return true;
    }
