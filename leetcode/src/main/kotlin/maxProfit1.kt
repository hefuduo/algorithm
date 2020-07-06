/**
 * Created by hefuduo on 2/29/20.
 */

/**
 * 买卖股票的最佳时机1
 */

fun main() {

}


fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty()) return 0
    var maxProfit = 0
    var minPrice = prices[0]
    for (i in 1 until prices.size) {
        if (prices[i] < minPrice) {
            minPrice = prices[i]
        } else if (prices[i] - minPrice > maxProfit) {
            maxProfit = prices[i] - minPrice
        }
    }
    return if (maxProfit < 0) 0 else maxProfit
}
