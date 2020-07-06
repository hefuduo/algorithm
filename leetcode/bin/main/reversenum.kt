/**
 * Created by hefuduo on 2/3/20.
 */

/*
 * 回文数
 */

fun main(args: Array<String>) {
    val x1 = 1001
    val x2 = 1234321
    println(isPalindrome2(x1))
    println(isPalindrome2(x2))

}

/**
 * 解题思路,不全部反转, 反转一般就可以.
 * https://leetcode-cn.com/problems/palindrome-number/solution/dong-hua-hui-wen-shu-de-san-chong-jie-fa-fa-jie-ch/
 * 这里直接放最取巧妙的方法
 * @param x Int
 * @return Boolean
 */
fun isPalindrome(x: Int): Boolean {
    var X: Int = x
    var reverseNum: Int = 0
    //边界条件:  小于0 的数 -121, 或者末尾是0的数 注意x =0 是回文数
    if (x < 0 || (x % 10 == 0 && x != 0))
        return false
    while (X > reverseNum) {
        reverseNum = reverseNum * 10 + X % 10
        X /= 10
    }
    //注意奇数偶数.如果是奇数个数字,那么需要将reverse后的number
    return X == reverseNum || X == reverseNum / 10
}

/**
 * 数学的方式依次比较.
 * @param x Int
 * @return Boolean
 */
fun isPalindrome2(x: Int): Boolean {
    //先找到最高位置.
    if (x < 0 || (x % 10 == 0 && x != 0))
        return false
    if (x == 0)
        return true

    var w = 1
    var temp = x
    while (temp >= 10) {
        temp /= 10
        w *= 10
    }
    temp = x
    while (temp != 0) {
        if (temp % 10 != temp / w) {
            return false
        }
        //去掉最高位和最低位
        temp = temp % w / 10
        //因为去掉了最高位和最低位, 将w 减小100数量级
        w /= 100
    }
    return true
}



