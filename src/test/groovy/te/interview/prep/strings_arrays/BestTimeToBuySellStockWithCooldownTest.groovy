package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class BestTimeToBuySellStockWithCooldownTest extends Specification {

    @Subject
    BestTimeToBuySellStockWithCooldown bestTimeToBuySellStockWithCooldown = []

    def "can can determine best time to buy/sell a multiple stock with cooldown"(int[] prices, int profit) {
        expect:
            bestTimeToBuySellStockWithCooldown.maxProfit(prices) == profit

        where:
            prices          || profit
            [1, 2, 3, 0, 2] || 3
    }

}
