/**
 * Created by hefuduo on 3/10/20.
 */

//爬楼梯

fun main() {

}

fun climbStairs(n: Int): Int {
    if (n == 0) return 0
    if (n == 1) return 1
    if (n == 2) return 2
    val arr = IntArray(n)
    arr[0] = 1
    arr[1] = 2
    for (i in 2 until arr.size) {
        arr[i] = arr[i - 1] + arr[i - 2]
    }
    return arr.last()
}
