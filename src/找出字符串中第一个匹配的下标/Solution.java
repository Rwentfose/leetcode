package 找出字符串中第一个匹配的下标;

import java.util.PriorityQueue;

class Solution {
    public int strStr(String haystack, String needle) {
        char[] haystackCharArray = haystack.toCharArray();
        PriorityQueue<Integer> queue = new PriorityQueue<>(1);
        char[] needleCharArray = needle.toCharArray();
        int start = 0;
        int end = needle.length();
        while (end <= haystack.length()) {
            int len = needle.length();
            for (int j = start; j < end; j++) {
                if (haystackCharArray[j] != needleCharArray[j - start]) {
                    break;
                } else {
                    len--;
                }
            }
            if (len == 0) {
                queue.add(start);
                start++;
                end++;
            } else {
                start++;
                end++;
            }
        }
        if (queue.isEmpty()) {
            return -1;
        } else {
            return queue.peek();
        }

    }

    public static void main(String[] args) {
        int i = new Solution().strStr("leetcode", "leeto");
        System.out.println(i);
    }
}