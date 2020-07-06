import kotlin.math.abs

/**
 * Created by hefuduo on 2/3/20.
 */

fun main(args: Array<String>) {
    val result = reverse2(-123)
}

/*
 * 反转有符号整数,超过MAX or  MIN 返回0
 * [tag] 数学
 * 2^31-1=2147483647,-2^31=-2147483648
 */

/**
 *使用字符串处理的方式: 不推荐.!!
 * @param x Int
 * @return Int
 */
fun reverse(x: Int): Int {
    val symbol: Int = if (x > 0) 1 else -1
    val value = abs(x).toString().reversed()
    return try {
        Integer.parseInt(value) * symbol
    } catch (e: Exception) {
        0
    }
}

/**
 * 使用纯数学的方法
 * 解题思路: https://leetcode-cn.com/problems/reverse-integer/solution/hua-jie-suan-fa-7-zheng-shu-fan-zhuan-by-guanpengc/
 * @param x Int
 * @return Int
 */
fun reverse2(x: Int): Int {
    var X = x
    var rev: Long = 0
    while (X != 0) {
        val pop: Int = X % 10
        X /= 10
        rev = rev * 10 + pop
    }
    return if (rev > Int.MAX_VALUE || rev < Int.MIN_VALUE)
        0
    else
        rev.toInt()

}

/**
 * 一种比较取巧的方法.
 * @param x Int
 * @return Int
 */
fun reverse3(x: Int): Int {
    var x = x
    var ans = 0
    while (x != 0) {
        // 判断边界
        if (ans * 10 / 10 != ans) {
            ans = 0
            break
        }
        ans = ans * 10 + x % 10
        x = x / 10
    }
    return ans
}

