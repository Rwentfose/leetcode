package 字符串反转;

class Solution {
    public void reverseString(char[] s) {
     int left = 0;
     int right = s.length-1;
     while(left<right){
         char tmp;
         tmp = s[left];
         s[left]= s[right];
         s[right]= tmp;
         left++;
         right--;
     }
    }

}