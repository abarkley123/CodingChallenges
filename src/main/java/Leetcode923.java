package main.java;

//Given an integer array A, and an integer target, return the number of tuples i, j, k  such that i < j < k and A[i] + A[j] + A[k] == target.
//
//        As the answer can be very large, return it modulo 10^9 + 7.
//
//
//
//        Example 1:
//
//        Input: A = [1,1,2,2,3,3,4,4,5,5], target = 8
//        Output: 20
//        Explanation:
//        Enumerating by the values (A[i], A[j], A[k]):
//        (1, 2, 5) occurs 8 times;
//        (1, 3, 4) occurs 8 times;
//        (2, 2, 4) occurs 2 times;
//        (2, 3, 3) occurs 2 times.
//        Example 2:
//
//        Input: A = [1,1,2,2,2,2], target = 5
//        Output: 12
//        Explanation:
//        A[i] = 1, A[j] = A[k] = 2 occurs 12 times:
//        We choose one 1 from [1,1] in 2 ways,
//        and two 2s from [2,2,2,2] in 6 ways.
//
//
//        Note:
//
//        3 <= A.length <= 3000
//        0 <= A[i] <= 100
//        0 <= target <= 300

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Leetcode923 {

    public int threeSumMulti(int[] A, int target) {
        int MOD = 1_000_000_007;
        int ret = 0;
        if (A == null || A.length < 3) return ret;
        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            int targ = target - A[i];

            int j = i+1;
            int k = A.length - 1;
            while (i < j) {
                if (A[j] + A[k] < targ) {
                    j++;
                } else if (A[j] + A[k] > targ) {
                    k--;
                } else if (A[j] != A[k]) {
                    // Let's count "left": the number of A[j] == A[j+1] == A[j+2] == ...
                    // And similarly for "right".

                    int left = 1, right = 1;
                    while (j + 1 < k && A[j] == A[j+1]) {
                        left++;
                        j++;
                    }

                    while (k - 1 > j && A[k] == A[k-1]) {
                        right++;
                        k--;
                    }

                    ret += left & right;
                    ret %= MOD;
                    j++;
                    k--;
                } else {
                    ret += (k - j+1) * (k - j) / 2;
                    ret %= MOD;
                    break;
                }
            }
        }

        return (int) ret;
    }
}

    class MainClass923 {
        public static int[] stringToIntegerArray(String input) {
            input = input.trim();
            input = input.substring(1, input.length() - 1);
            if (input.length() == 0) {
                return new int[0];
            }

            String[] parts = input.split(",");
            int[] output = new int[parts.length];
            for(int index = 0; index < parts.length; index++) {
                String part = parts[index].trim();
                output[index] = Integer.parseInt(part);
            }
            return output;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                int[] A = stringToIntegerArray(line);
                line = in.readLine();
                int target = Integer.parseInt(line);

                int ret = new Leetcode923().threeSumMulti(A, target);

                String out = String.valueOf(ret);

                System.out.print(out);
            }
        }
    }
