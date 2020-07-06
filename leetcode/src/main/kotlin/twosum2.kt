/**
 * Created by hefuduo on 2/19/20.
 */

fun main() {

}


/**
 * 双指针法,注意是排序数组
 * @param numbers IntArray
 * @param target Int
 * @return IntArray
 */
fun twoSum2(numbers: IntArray, target: Int): IntArray {
    var array: IntArray = IntArray(2)
    var pre = 0
    var post = numbers.size - 1
    var sum = numbers[pre] + numbers[post]
    while (sum != target) {
        if (sum > target) {
            post--
        } else if (sum < target) {
            pre++
        }
    }
    array[0] = pre + 1
    array[1] = post + 1
    return array
}
