package com.interview.arrays;

import java.util.stream.IntStream;

/**
 * LeetCode 121 - Best Time to Buy and Sell Stock.
 * Devuelve la maxima ganancia posible comprando y vendiendo una vez.
 *
 * PATRON: Greedy — llevar el precio minimo visto y la mejor ganancia posible.
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock stock = new BestTimeToBuyAndSellStock();
        System.out.println(stock.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        return maxProfitImperative(prices);
    }

    public int maxProfitImperative(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // mejor precio de compra hasta el momento
        int maxProfit = 0; // mejor ganancia encontrada

        for (int price : prices) {
            minPrice = Math.min(minPrice, price); // comprar lo mas barato posible
            maxProfit = Math.max(maxProfit, price - minPrice); // vender hoy vs minimo previo
        }
        return maxProfit;
    }

    public int maxProfitFunctional(int[] prices) {
        int[] minPrice = {Integer.MAX_VALUE};
        return IntStream.of(prices)
            .map(price -> {
                minPrice[0] = Math.min(minPrice[0], price);
                return price - minPrice[0]; // ganancia si vendo en este dia
            })
            .max() // nos quedamos con la mayor ganancia
            .orElse(0);
    }
}
