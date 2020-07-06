/**
 * Created by hefuduo on 2/6/20.
 */
/*
X的平方根
 */

fun main(args: Array<String>) {
    println(mySqrt(2.0))
}

/**
 * 取整数版
 * 平方根
 * @param x Int
 * @return Int
 */
fun mySqrt(x: Int): Int {
    var prev: Double = x.toDouble()
    var cur: Double = prev
    while (true) {
        cur = (prev + x / prev) / 2
        if (prev == cur)
            return cur.toInt()
        prev = cur
    }
}


/**
 * 高精度版本
 * @param x Double
 * @return Double
 */
fun mySqrt(x: Double): Double {
    var prev: Double = x
    var cur: Double = prev
    while (true) {
        cur = (prev + x / prev) / 2
        if (prev == cur)
            return cur
        prev = cur
    }
}
