/**
 * Created by hefuduo on 3/17/20.
 */

//三步走问题, 上台阶可1,2,3 步问 爬到n台阶有多少种走法

fun main() {

}

fun waysToStep(n: Int): Int {
    return when (n) {
        0 -> 1
        1 -> 1
        2 -> 2
        else -> {
            val res = IntArray(n + 1)
            res[0] = 1
            res[1] = 1
            res[2] = 2
            for (i in 3 until res.size) {
                res[i] = res[i - 1] + res[i - 2] + res[i - 3]
            }
            return Math.floorMod(res.last() ,1000000007)
        }
    }
}


