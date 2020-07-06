/**
 * Created by hefuduo on 2/4/20.
 */
/*
 * 最长公共字符串前缀
 */

fun main(args: Array<String>) {
    println("")
}


/**
 * https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode/
 *这个方法只是下一个方法的一个灵活的实现, 主要活用了indexOf和subString
 * @param strs Array<String>
 * @return String
 */
fun longestCommonPrefix(strs: Array<String>): String {
    //边界.
    if (strs.isEmpty())
        return ""
    var prefix = strs[0]
    for (i in strs.indices) {
        //不存在返回-1, 存在返回第一个字符所在的位置.
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length - 1)
            if (prefix.isEmpty())
                return ""
        }
    }
    return prefix
}


/**
 * 按照列比较,直到找到不同的下标的那一列为止,返回从0-下标的那个子串.
 * @param strs Array<String>
 * @return String
 */
fun longestCommonPrefix2(strs: Array<String>): String {
    //边界.
    if (strs.isEmpty())
        return ""

    for (i in strs[0].indices) {
        var c = strs[0][i]
        for (j in 1 until strs.size) {
            //碰到不同或者越界了,就返回子串.
            if (i == strs[j].length || strs[j][i] != c)
                return strs[0].substring(0, i)
        }
    }
    //考虑一种情况, 第一个字符串是所有字符串的子串
    return strs[0]
}
