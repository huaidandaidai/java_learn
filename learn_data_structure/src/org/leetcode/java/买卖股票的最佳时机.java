package org.leetcode.java;

public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if(prices == null) return 0;
        int low=prices[0],height=prices[0];
        for(int i=0;i<prices.length;i++){
            if(low<prices[i]){
                low=prices[i];
            }
        }
        return 0;
    }
}
