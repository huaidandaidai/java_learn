package org.leetcode.java;

public class Leet02 {
    public static int reverse(int x) {
        String xs= String.valueOf(x);
        char[] xsx=xs.toCharArray();
        StringBuffer sb=new StringBuffer();
        Integer result=0;
        if(x>0){
            for(int i=xsx.length-1;i>=0;i--){
                sb.append(xsx[i]);
            }
            result=Integer.valueOf(sb.toString());
        }else{
            for(int i=xsx.length-1;i>0;i--){
                sb.append(xsx[i]);
            }
            result=Integer.valueOf(sb.toString())*-1;
        }
        return result;
    }

    public static void main(String[] args) {
        int x=-123456;
        System.out.println(reverse(x));
    }
}
