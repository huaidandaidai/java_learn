package org.interview.zd;

public class Topic3 {
    public static void main(String[] args) {
        String[] strs={"abc","abcd","abcde","abc","abcd"};
        int index=0;
        int length=0;
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].contains("abc")&&strs[i].length()>length){
                length=strs[i].length();
                index=i;
            }
        }
        System.out.println(strs[index]);
    }
}
