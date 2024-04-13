package 赎金信;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
         int[] record = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            record[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            record[ransomNote.charAt(i) - 'a']--;
        }
        for (int i = 0; i < record.length; i++) {
            if (record[i] < 0){
                return false;
            }else {
                continue;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = new Solution().canConstruct("bj", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj");
        System.out.println(b);
    }
}