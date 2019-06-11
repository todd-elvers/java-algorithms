package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class BestTimeToBuySellStockTest extends Specification {

    @Subject
    BestTimeToBuySellStock bestTimeToBuySellStock = []

    def "can determine best time to buy/sell stock"(int[] prices, int profit) {
        expect:
            bestTimeToBuySellStock.maxProfit(prices) == profit

        where:
            prices             || profit
            [7, 1, 5, 3, 6, 4] || 5
            [7, 6, 4, 3, 1]    || 0
    }

}
