package main.java;

//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//
//        A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
//
//        Example:
//
//        Input: "23"
//        Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Leetcode17 {

    private static final Map<Character, String> numbers = new HashMap<>();

    static {
        numbers.put('2', "abc");
        numbers.put('3', "def");
        numbers.put('4', "ghi");
        numbers.put('5', "jkl");
        numbers.put('6', "mno");
        numbers.put('7', "pqrs");
        numbers.put('8', "tuv");
        numbers.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> str = new ArrayList<>();
        if (digits == null || digits.length() == 0) return str;

        return recurse(str, "", 0, digits);
    }

    private List<String> recurse(List<String> arr, String current, int pos, String digits) {
        if (pos == digits.length()) {
            arr.add(current);
            return arr;
        }

        String dig = numbers.get(digits.charAt(pos));
        for (int i = 0; i < dig.length(); i++) {
            current += dig.charAt(i);
            recurse(arr, current, pos+1, digits);
            current = current.substring(0, current.length()-1);
        }

        return arr;
    }
}

class MainClass17 {

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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
//        while ((line = in.readLine()) != null) {
            String digits = "234";
            List<String> ret = new Leetcode17().letterCombinations(digits);

            String out = stringListToString(ret);

            System.out.print(out);
//        }
    }
}
