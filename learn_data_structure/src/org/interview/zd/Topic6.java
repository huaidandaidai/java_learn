package org.interview.zd;

import java.util.Scanner;

public class Topic6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int arr[] = new int[N];
        int i = 0;
        int callNum = 0;
        int outNum = 0;
        while (true) {
            //如果未置成1
            if (arr[i] == 0) {
                //如果未出局人数为一，结束循环
                if (arr.length - outNum == 1) {
                    break;
                } else {
                    //报数
                    callNum++;
                    //当报数值为3的时候
                    if (callNum % 3 == 0) {
                        //置值为1
                        arr[i] = 1;
                        //出局人数加1
                        outNum++;
                        //重置报数
                        callNum = 0;
                    }
                }
            }
            //下标跳跃到下一个
            i++;
            //当下标与N
            i = i % N;
        }
        System.out.println(i + 1);
    }
}
