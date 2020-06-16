package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//        Given an array nums and a value val, remove all instances of that value in-place and return the new length.
//        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//        The order of elements can be changed. It doesn't matter what you leave beyond the new length.
//
//        Example 1:
//        Given nums = [3,2,2,3], val = 3,
//        Your function should return length = 2, with the first two elements of nums being 2.
//        It doesn't matter what you leave beyond the returned length.


// OUTCOME:
//        Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
//        Memory Usage: 35.3 MB, less than 100.00% of Java online submissions for Remove Element.
//
// EVALUATION:
//        This program took far longer than ideal to solve. Nested while loop proved to be a constant source for bugs.
//        Output: Attempt to solve pure 'brute force' first, then consider optimisations.

public class Leetcode27 {

        //Swap the elements equal to val with the value at the end of the arr
        public int removeElement(int[] nums, int val) {
            //handle edge cases
            if (nums == null) return 0;
            else if (nums.length == 1) return nums[0] != val ? 1 : 0;
            int length = nums.length;

            int i = -1;
            while (++i < nums.length) {
                //if we have looked through all the elements, break.
                if (nums[i] == Integer.MAX_VALUE || length <= 0) break;
                while (nums[i] == val && i <= length && length > 0) {
                    swap(nums, i, length);
                    length--;
                    }
                }

            return length;
        }

        //Helper function for debugging purposes.
        private static void printArray(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i] + ", ");
            }

            System.out.println();
        }

        //Swap current index with the last 'non visited' element in the array.
        private void swap(int[] nums, int a, int length) {
            int index = nums.length - 1 - (nums.length - length);
            int temp = nums[index];
            nums[index] = Integer.MAX_VALUE;
            if (index != a) {
                nums[a] = temp;
            }
        }

        /** GIVEN SOLUTION **/
        public int removeElementSolution1(int[] nums, int val) {
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    i++;
                }
            }
            return i;
        }

        /** GIVEN SOLUTION 2 **/
        public int removeElementSolution2(int[] nums, int val) {
            int i = 0;
            int n = nums.length;
            while (i < n) {
                if (nums[i] == val) {
                    nums[i] = nums[n - 1];
                    // reduce array size by one
                    n--;
                } else {
                    i++;
                }
            }
            return n;
        }

        //My algorithm performs better than each solution, though is much more verbose. I should consider simpler solutions when trying to solve these problems.
    }

    class MainClass {

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

        public static String integerArrayToString(int[] nums, int length) {
            if (length == 0) {
                return "[]";
            }

            String result = "";
            for(int index = 0; index < length; index++) {
                int number = nums[index];
                result += Integer.toString(number) + ", ";
            }
            return "[" + result.substring(0, result.length() - 2) + "]";
        }

        public static String integerArrayToString(int[] nums) {
            return integerArrayToString(nums, nums.length);
        }

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                int[] nums = stringToIntegerArray(line);
                line = in.readLine();
                int val = Integer.parseInt(line);

                int ret = new Leetcode27().removeElement(nums, val);
                String out = integerArrayToString(nums, ret);

                System.out.print(out);
            }
        }
}
