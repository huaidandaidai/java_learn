package org.interview.zd;

/**
 * 输入: ''Hello World'' 实现输出‘’World Hello''
 */
public class Topic4 {
    public static void main(String[] args) {
        String s="Hello world";
        String[] strs=s.split(" ");
        StringBuffer newS=new StringBuffer();
        for (int i = strs.length-1; i >=0 ; i--) {
            newS.append(strs[i]);
            newS.append(" ");
        }
        System.out.println(newS.toString());
    }
}
