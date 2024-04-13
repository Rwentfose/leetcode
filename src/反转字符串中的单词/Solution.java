package 反转字符串中的单词;

import java.util.Arrays;

class Solution {
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (!s1[i].equals("")) {
                res.append(s1[i]);
                res.append(" ");
            }
        }
        return  res.toString().trim();
    }

    public static void main(String[] args) {

    }
}