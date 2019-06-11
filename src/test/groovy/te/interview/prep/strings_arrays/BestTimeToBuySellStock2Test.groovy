package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class BestTimeToBuySellStock2Test extends Specification {

    @Subject
    BestTimeToBuySellStock2 bestTimeToBuySellStock2 = []

    def "can determine best time to buy/sell a single stock"(int[] prices, int profit) {
        expect:
            bestTimeToBuySellStock2.maxProfit(prices) == profit

        where:
            prices             || profit
            [7, 1, 5, 3, 6, 4] || 7
            [1, 2, 3, 4, 5]    || 4
            [7, 6, 4, 3, 1]    || 0
    }

}
