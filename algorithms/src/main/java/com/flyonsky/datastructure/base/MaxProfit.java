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
        int maxProfix = maxProfix(prices);
        System.out.println(maxProfix);
    }

    /**
     * 最大利润
     * @param prices
     * @return
     */
    public static int maxProfix(int[] prices){
        int profix = 0;

        if(prices != null && prices.length >= 2){
            int minPrice = prices[0];
            int maxPrice = prices[0];
            for(int i=1; i < prices.length; i++){
                if(prices[i] >= maxPrice){
                    maxPrice = prices[i];
                } else {
                    profix += maxPrice - minPrice;
                    minPrice = prices[i];
                    maxPrice = prices[i];
                }
                if(prices[i] < minPrice){
                    minPrice = prices[i];
                    maxPrice = prices[i];
                    continue;
                }
            }
            if(minPrice != maxPrice){
                profix += maxPrice - minPrice;
            }
        }
        return profix;
    }
}
