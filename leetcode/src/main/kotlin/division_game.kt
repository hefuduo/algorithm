/**
 * Created by hefuduo on 3/17/20.
 */

//除数博弈(动态规划)

fun main() {
}

//数学解法
fun divisorGame(N: Int): Boolean {
    return N % 2 == 0
}

//动态规划

fun divisorGame2(N: Int): Boolean {
    if (N == 1) return false //n=1时,先走赢
    if (N == 2) return true //n=2时,先走输
    val array = BooleanArray(N + 1)
    array[1] = false
    array[2] = true

    for (i in 3..N) {
        array[i] = false
        for (j in 1 until i) {
            if (!array[i-j] && i % j == 0) { //让下一步先走的那个人输
                array[i] = true
                break
            }
        }
    }
    return array[N]
}

