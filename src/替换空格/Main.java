package 替换空格;

import java.util.Arrays;

public class Main {

    public static String  replaceSpace(String str) {
        char[] charArray = str.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == ' '){
                count++;
            }
        }
        char[] chars = new char[charArray.length + 2 * count];
        chars=charArray;
        for (int i = chars.length; i >0 ; i--) {
            if (chars[i] == ' '){
                //把空格后的字符向后移动四
                System.arraycopy(chars,i+1,chars,i+count*2,charArray.length-i);
                count--;
                chars[i+count]='%';
                chars[i+count+1]='2';
                chars[i+count+2]='0';
            }
        }
        return  new String(chars);
    }
}
