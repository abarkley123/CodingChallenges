package main.java;

public class Leetcode868 {


        public int binaryGap(int N) {
            String s = Integer.toBinaryString(N);

            int minDistance = 0, prev = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    if (prev >= 0) {
                        minDistance = Math.max(minDistance, i - prev);
                    }

                    prev = i;
                }
            }

            return minDistance;
        }

}
