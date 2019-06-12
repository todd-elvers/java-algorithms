package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">Problem on leetcode</a>
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations">Detailed explanation</a>
 */
public class BestTimeToBuySellStockWithCooldown {

    /*
        Time : O(n)
        Space: O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        // Today
        int buyToday = -prices[0];  // Cost of buying today is the price of today
        int sellToday = 0;          // Cannot sell today

        // Yesterday
        int buy1DayAgo = buyToday;
        int sell1DayAgo = 0;

        // Day before yesterday
        int sell2DaysAgo = 0;

        for (int i = 1; i < prices.length; i++) {
            buyToday = Math.max(buy1DayAgo, sell2DaysAgo - prices[i]);
            sellToday = Math.max(sell1DayAgo, buy1DayAgo + prices[i]);

            // Update previous day values for next iter
            buy1DayAgo = buyToday;
            sell2DaysAgo = sell1DayAgo;
            sell1DayAgo = sellToday;
        }

        return sellToday;
    }

}
