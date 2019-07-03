package org.interview.zd;

/**
 * 有一数组5,10,8,7,9,3，请输出最大值
 */
public class Topic5 {
    public static void main(String[] args) {
        int[] arr={5,10,8,7,9,3};
        int result=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>result){
                result=arr[i];
            }
        }
        System.out.println(result);
    }
}
