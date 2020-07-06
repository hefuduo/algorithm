/**
 * Created by hefuduo on 3/17/20.
 */
// 最小化费爬楼梯

fun main() {

}

fun minCostClimbingStairs(cost: IntArray): Int {
    if (cost.isEmpty())
        return 0
    if (cost.size == 1)
        return cost[0]
    if (cost.size == 2) {
        return Math.min(cost[0], cost[1])
    }
    val minCost = IntArray(cost.size + 1)
    minCost[0] = cost[0]
    minCost[1] = cost[1]
    for (i in 2 until minCost.size) {
        minCost[i] = Math.min(minCost[i - 2] + cost[i-2], minCost[i - 1] + cost[i -1])
    }
    return minCost.last()
}
