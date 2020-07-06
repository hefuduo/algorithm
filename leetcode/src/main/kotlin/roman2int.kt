/**
 * Created by hefuduo on 2/4/20.
 */

/*
 * 将罗马数字转换为纯数字
 *
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
链接：https://leetcode-cn.com/problems/roman-to-integer
 */
fun main(args: Array<String>) {
    println(romanToInt("MCMXCIV"))
}

fun romanToInt(s: String): Int {
    val map: HashMap<Char, Int> = HashMap()
    map['I'] = 1
    map['V'] = 5
    map['X'] = 10
    map['L'] = 50
    map['C'] = 100
    map['D'] = 500
    map['M'] = 1000
    val romanCharArray = s.toCharArray()
    var i = romanCharArray.size - 1
    var sum = 0
    while (i >= 0) {
        if (i - 1 >= 0 && (map[romanCharArray[i]]!! > map[romanCharArray[i - 1]]!!)) {
            sum += map[romanCharArray[i]]!! - map[romanCharArray[i - 1]]!!
            i -= 1
        } else {
            sum += map[romanCharArray[i]]!!
        }
        i--
    }
    return sum
}
