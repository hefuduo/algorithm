import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * Created by hefuduo on 2/4/20.
 */

/*
 * 有效的括号
 */

fun main(args: Array<String>) {
    val s1 = "[]{}()"
    val s2 = "({})"
    val s3 = "{]}()["
    println(isValid(s1))
    println(isValid(s2))
    println(isValid(s3))
}

fun isValid(s: String): Boolean {
    val charArray = s.toCharArray()
    if (charArray.size % 2 != 0) {
        return false
    }

    //<start, end>
    val dict = HashMap<Char, Char>()
    dict['{'] = '}'
    dict['('] = ')'
    dict['['] = ']'
    val statSet = dict.keys
    val endSet = dict.values

    val stack = LinkedList<Char>()
    for (i in charArray.indices) {
        if (charArray[i] in statSet) {
            stack.push(charArray[i])
        } else if (charArray[i] in endSet && charArray[i] == dict[stack.peek()]) {
            stack.pop()
        }
    }
    return stack.size == 0
}


