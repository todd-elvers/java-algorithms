package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">Problem on
 * leetcode</a>
 */
public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // The fact we only do one operation at a time (update min or update profit),
        // and the fact we calculate the profit eagerly, ensures we always sell our
        // stocks after we've bought them.
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }

}
