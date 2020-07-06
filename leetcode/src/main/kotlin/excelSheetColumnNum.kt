/**
 * Created by hefuduo on 2/18/20.
 */

fun main() {
    println(titleToNumber("AAA"))
}

/**
 * 其实就是26进制嘛
 * @param s String
 * @return Int
 */
fun titleToNumber(s: String): Int {
    val a = s.toCharArray()
    fun getNum(c: Char): Int {
        return c.toInt() - 'A'.toInt() + 1
    }
    var result = 0
    for (i in a.indices) {
        result = result * 26 + getNum(a[i])
    }
    return result
}
