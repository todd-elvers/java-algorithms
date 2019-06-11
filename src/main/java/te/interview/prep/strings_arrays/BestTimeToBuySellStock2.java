package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">Problem on
 * leetcode</a>
 */
public class BestTimeToBuySellStock2 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        // Since we can now buy/sell repeatedly (as long as we buy AND sell before buying again)
        // all we must do to find the total profit possible is always buy and sell if the previous
        // day was lower than the current day.  Even if that isn't the optimal purchase, after
        // we go through every day it will be equivalent to the optimal purchase.
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

}
