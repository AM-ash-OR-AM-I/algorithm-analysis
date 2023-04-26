package arrays;

import utils.Util;

/*
 * In given list, in which nth element is the price of the stock on nth day.
You are asked to buy once and sell once, on what date you will be buying and at what date you will be selling to get maximum profit.
Or
In given list of numbers, you need to maximize the difference between two
numbers, such that you can subtract the number, which appears before form the
number that appear after it.
 */

public class Stocks {
    static void maximizeStocks(int[] arr) {
        int buyDay = 0, sellDay = 1;
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        int minBuy = 0;
        int currProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            if (x < min) {
                min = x;
                minBuy = i + 1;
            }
            currProfit = x - min;
            if (currProfit > maxProfit) {
                buyDay = minBuy;
                sellDay = i + 1;
                maxProfit = currProfit;
            }
        }
        System.out.printf("Buy at day %d and sell at day %d & profit = %d%n", buyDay, sellDay, maxProfit);
    }

    static void maximizeStocks2(int[] arr) {
        int n = arr.length;
        int maxProfit = Integer.MIN_VALUE;
        String buySel = "";
        int i = 0, j = n - 1;
        while (i < j) {
            int x = arr[j] - arr[i];
            if (x > maxProfit) {
                maxProfit = x;
                buySel = i + "-->" + j;
            }
            if (arr[j] < arr[i]) {
                j--;
            } else {
                i++;
            }
        }
        System.out.printf("Buy %s & profit = %s", buySel, maxProfit);
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        maximizeStocks(arr);
        maximizeStocks2(arr);
    }
}
