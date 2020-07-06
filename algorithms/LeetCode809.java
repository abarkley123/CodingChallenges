package main.java;
//
//Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".
//
//        For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.
//
//        For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.
//
//        Given a list of query words, return the number of words that are stretchy.

// expressive words - https://leetcode.com/problems/expressive-words/
public class LeetCode809 {

    public int expressiveWords(String S, String[] words) {
        if (S == null || S.length() == 0 || words == null || words.length == 0) return 0;

        int ret = 0;
        for (int i = 0; i < words.length; i++)
            if (isStretchy(words[i], S)) ret++;


        return ret;
    }

    private static boolean isStretchy(String str, String target) {
        char[] a = str.toCharArray();
        char[] b = target.toCharArray();

        int j = 0, i = 0;
        while (i < a.length && j < b.length) {
            if (a[i] != b[j]) return false;

            char c = a[i];
            int count1 = 0, count2 = 0;
            while (i < a.length && a[i] == c) {
                count1++;
                i++;
            }

            while (j < b.length && b[j] == c) {
                count2++;
                j++;
            }

            if (count2 < count1 || (count1 < count2 && count2 < 3)) return false;
        }

        return j >= i && j > b.length - 1 && a.length <= b.length;
    }
}
