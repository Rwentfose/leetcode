package 反转字符串二;

class Solution {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i+= 2*k) {
            int left = i;
            int right = Math.min(i + k - 1, s.length() - 1);
            while (left < right){
                char tmp;
                tmp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = tmp;
                left++;
                right--;
            }
        }
        return  new String(charArray);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseStr("abcdefgr", 3));
    }
}