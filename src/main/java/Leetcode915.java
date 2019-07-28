package main.java;

//Given an array A, partition it into two (contiguous) subarrays left and right so that:
//
//        Every element in left is less than or equal to every element in right.
//        left and right are non-empty.
//        left has the smallest possible size.
//        Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.
//
//        Example 1:
//
//        Input: [5,0,3,8,6]
//        Output: 3
//        Explanation: left = [5,0,3], right = [8,6]
//        Example 2:
//
//        Input: [1,1,1,0,6,12]
//        Output: 4
//        Explanation: left = [1,1,1,0], right = [6,12]
//
//
//        Note:
//
//        2 <= A.length <= 30000
//        0 <= A[i] <= 10^6
//        It is guaranteed there is at least one way to partition A as described.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Leetcode915 {

    public int partitionDisjoint(int[] A) {
        if (A == null || A.length < 2) return 0;

        int length = 1;
        int[] left, right;
        for (int i = 1; i < A.length; i++) {
            left = buildSortedArray(A, 0, i);
            right = buildSortedArray(A, i + 1, A.length);

            System.out.println(left[left.length-1] + " " + right[0]);
            if (left[left.length - 1] <= right[0] && ) length++;
            else break;
        }

        return length;
    }

    public int[] buildSortedArray(int[] orig, int startIndex, int endIndex) {
        int[] sorted = new int[endIndex - startIndex];

        int counter = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sorted[counter++] = orig[i];
        }

        Arrays.sort(sorted);
        return sorted;
    }

    //actual solution
    public int partitionDisjointCorrect(int[] A) {
        int globalMax = A[0];
        int leftMax = A[0];
        int boundary = 0;

        for (int i=0; i < A.length; i++) {
            globalMax = A[i] > globalMax ? A[i] : globalMax;
            if (A[i] < leftMax) {
                boundary = i;
                leftMax = globalMax > leftMax ? globalMax : leftMax;
            }
        }
        return boundary+1;
    }
}
    class MainClass915 {
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

                int ret = new Leetcode915().partitionDisjoint(A);

                String out = String.valueOf(ret);

                System.out.print(out);
            }
        }
}
