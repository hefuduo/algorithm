/**
 * Created by hefuduo on 2/19/20.
 */

fun main() {
    println(convertToTitle(701))
}


/**
 * 注意是从1开始的没有0.需要进行对1的特殊处理
 * @param n Int
 * @return String
 */
fun convertToTitle(n: Int): String {
    var res = ""
    var N = n
    while (N > 0) {
        var mod = (N - 1) % 26
        res = ('A' + mod) + res
        N = (N - 1) / 26;
    }
    return res
}
