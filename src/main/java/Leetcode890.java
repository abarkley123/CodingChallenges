package main.java;

import java.io.IOException;
import java.util.*;

//    You have a list of words and a pattern, and you want to know which words in words matches the pattern.
//    A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
//            (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
//
//    Return a list of the words in words that match the given pattern.
//
//    You may return the answer in any order.
//
//    Example 1:
//    Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//    Output: ["mee","aqq"]
//    Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
//            "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
//    since a and b map to the same letter.
//
//
//            Note:
//
//            1 <= words.length <= 50
//            1 <= pattern.length = words[i].length <= 20

// OUTPUT:
//        Runtime: 2 ms, faster than 81.94% of Java online submissions for Find and Replace Pattern.
//        Memory Usage: 36 MB, less than 99.32% of Java online submissions for Find and Replace Pattern.


    public class Leetcode890 {

        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> str = new ArrayList<>();
            if (words == null || words.length == 0) return str;

            int uniqueChars = numUniqueChars(pattern);
            Map<Character, Character> map = new HashMap<>();
            outerLoop: for (String word : words) {
                if (word.length() != pattern.length()) continue;

                map.clear();
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    if (map.containsKey(arr[i]) && map.get(arr[i]) != pattern.charAt(i)) {
                        continue outerLoop;
                    } else if (!map.containsKey(arr[i])) {
                        map.put(arr[i], pattern.charAt(i));
                    }
                }

                if (map.size() == uniqueChars) str.add(word);
            }

            return str;
        }

        private static int numUniqueChars(String str) {
            int total = 0;
            char[] arr = str.toCharArray();
            Set<Character> uniqueChars = new HashSet<>();

            for (char c : arr) {
                if (uniqueChars.add(c)) total++;
            }

            return total;
        }
    }

    class MainClass890 {

        public static String stringListToString(List<String> stringList) {
            StringBuilder sb = new StringBuilder("[");
            for (String item : stringList) {
                sb.append(item);
                sb.append(",");
            }

            sb.setCharAt(sb.length() - 1, ']');
            return sb.toString();
        }

        public static void main(String[] args) throws IOException {
            String[] words = {"abce","deqe","meee","aqeq","dkde","ccce"};
            String pattern = "abxb";
            List<String> ret = new Leetcode890().findAndReplacePattern(words, pattern);

            String out = stringListToString(ret);

            System.out.print(out);
        }
}
