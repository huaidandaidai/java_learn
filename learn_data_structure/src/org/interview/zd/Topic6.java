package org.interview.zd;


import java.util.ArrayList;
import java.util.List;

/**
 * 一个字符串有n个字符，
 * 从第一个字符开始数，第m个字符从串中移除并输出，再接着从下一个字符继续数，
 * 第m个从串中移除并输出，数到末尾从头接着数，直到串中小于m个字符为止
 */
public class Topic6 {
    public static void main(String[] args) {
        yuesefu(10, 3);
    }
    public static void yuesefu(int totalNum, int countNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        // 从第K个开始计数
        int k = 0;
        while (start.size() > 0) {
            k = k + countNum;
            // 第m人的索引位置
            k = k % start.size() - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.println(start.get(start.size() - 1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
    }
}
