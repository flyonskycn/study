package com.flyonsky.datastructure.base;

/**
 * @author luowengang
 * @date 2021/5/22 20:54
 */
public class MaxProfit {

    public static void main(String[] args){
//        int[] prices = {7, 1, 5, 3, 6};
//        int[] prices = {7, 1};
//        int[] prices = {1, 2, 3, 4, 5};
//        int[] prices = {7, 6, 4, 3, 1};
        int[] prices = {2, 4, 1};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    /**
     * 最大利润
     * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 时间复杂度O(n),空间复杂度O(1)
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices){
        int profit = 0;

        if(prices != null && prices.length >= 2){
            int minPrice = prices[0];
            int maxPrice = prices[0];
            for(int i=1; i < prices.length; i++){
                if (prices[i] < maxPrice) {
                    profit += maxPrice - minPrice;
                    minPrice = prices[i];
                }
                maxPrice = prices[i];
                if(prices[i] < minPrice){
                    minPrice = prices[i];
                    maxPrice = prices[i];
                    continue;
                }
            }
            if(minPrice != maxPrice){
                profit += maxPrice - minPrice;
            }
        }
        return profit;
    }
}
