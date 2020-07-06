/**
 * Created by hefuduo on 2/5/20.
 */

fun main(args: Array<String>) {
    println(countAndSay(5))
}

//([\d]\1{5})
//[\d]数字 \
/**
 * https://leetcode-cn.com/problems/count-and-say/solution/tong-guo-zheng-ze-he-bing-xiang-tong-yuan-su-wan-c/
 * 外观数列,使用正则方式
 * @param n Int
 * @return String
 */
fun countAndSay(n: Int): String {
    if (n == 1) {
        return "1"
    }
    //想想怎么用正则
    return countAndSay(n - 1).replace(Regex("(\\d)\\1{0,2}")) {
        return@replace it.value.length.toString() + it.value[0]
    }
}


/**
 * 用递归方法求解.
 * @param n Int
 * @return String
 */
fun countAndSay2(n: Int): String {
//    ??
    return ""
}


