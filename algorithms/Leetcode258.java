    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;

            for (char c : Integer.toString(num).toCharArray()) {
                sum += c - '0';
            }
            
            num = sum;
        }
               
        return num;
    }
