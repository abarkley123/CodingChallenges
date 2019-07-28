package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//        (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
//        You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//        You may assume no duplicate exists in the array.
//
//        Your algorithm's runtime complexity must be in the order of O(log n).
//
//        Example 1:
//
//        Input: nums = [4,5,6,7,0,1,2], target = 0
//        Output: 4
//        Example 2:
//
//        Input: nums = [4,5,6,7,0,1,2], target = 3
//        Output: -1

public class LeetCode33 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] arr, int start, int end, int target) {
        int ret = - 1;
        int index = start + (end-start)/2;
        if (start >= end) return arr[index] == target ? index : ret;
        int middle = arr[index];

        if (middle == target) ret = index;
        else ret = shouldGoRight(arr[start], arr[end], middle, target) ? binarySearch(arr, index + 1, end, target)  : binarySearch(arr, start, index, target);

        return ret;
    }

    private boolean shouldGoRight(int start, int end, int middle, int target) {
        boolean goRight = true;

        if (start > end) {
            if (start > target) {
                if (middle < start && middle > target) goRight = false;
            } else { // start <= target
                if (middle > target || middle < start) goRight = false;
            }
        } else { //end < start (since there are no duplicates)
            if (end <= target) {
                if (middle > target) goRight = false;
            } else {
                if (middle > end || middle > target) goRight = false;
            }
        }
        return goRight;
    }
}

class MainClass33 {
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
                int[] nums = stringToIntegerArray(line);
                line = in.readLine();
                int target = Integer.parseInt(line);

                int ret = new LeetCode33().search(nums, target);

                String out = String.valueOf(ret);

                System.out.print(out);
            }
        }
    }
