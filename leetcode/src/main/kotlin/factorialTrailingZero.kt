/**
 * Created by hefuduo on 2/18/20.
 */
fun main(args: Array<String>) {
    val re = trailingZeroes(25)
    println(re)
}

/*
解题思路:
尾部有多少个0 就有多少个10 => 就有多少个2*5
转换为找 n!中因式分解后5的个数
n! = x * 2^a * 5^b (这里a是大于b的)
于是就转化为
这里就是求b的值

想想等比数列的求和?
 */

/** 递归方式
 * @param n Int
 * @return Int
 */
fun trailingZeroes(n: Int): Int {
    return if (n >= 5) {
        n / 5 + trailingZeroes(n / 5)
    } else 0
}

/**
 * 非递归形式.
 * @param n Int
 * @return Int
 */
fun trailingZeros(n: Int): Int {
    var count = 0
    var N = n
    while (n >= 5) {
        count += N / 5  //先求有一个5的   k/a = b,证明 从0-k有b个 可以被a整除的数.
        N /= 5        //再求有两个5的(先把一个5划掉(除掉)了,实际上还是求一个5的)
                        // 一次类推.
    }
    return count
}
