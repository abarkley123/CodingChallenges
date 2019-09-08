public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();
        int number = 0;
        int[] ch = new int[26];
        int[] num = new int[2];
        boolean isSame = false;
        for (int i = 0; i < charsA.length; i++) {
            if (!isSame) {
                ch[charsA[i] - 'a'] += 1;
                if (ch[charsA[i] - 'a'] >= 2) {
                    isSame = true;
                }
            }
            if (charsA[i] != charsB[i]) {
                num[0] += charsA[i];
                num[1] += charsB[i];
                number++;
            }
        }
        if (number == 2 && num[0] == num[1] || number == 0 && isSame) {
            return true;
        }
        return false;
    }
