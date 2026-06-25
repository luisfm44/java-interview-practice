package com.interview.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockTest {

  private final BestTimeToBuyAndSellStock stock = new BestTimeToBuyAndSellStock();

  @Test
  void findsMaximumProfit() {
    assertEquals(5, stock.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
  }

  @Test
  void returnsZeroWhenNoProfitIsPossible() {
    assertEquals(0, stock.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
  }

  @Test
  void imperativeFindsMaximumProfit() {
    assertEquals(5, stock.maxProfitImperative(new int[] { 7, 1, 5, 3, 6, 4 }));
  }

  @Test
  void imperativeReturnsZeroWhenNoProfitIsPossible() {
    assertEquals(0, stock.maxProfitImperative(new int[] { 7, 6, 4, 3, 1 }));
  }
}
