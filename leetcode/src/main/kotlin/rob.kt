/**
 * Created by hefuduo on 3/10/20.
 */

//打家劫舍

fun main() {
    val a = arrayOf(1, 3, 1, 3, 100).toIntArray()
    println(rob(a))
}


fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return nums[0]
    if (nums.size == 2) return nums[0].coerceAtLeast(nums[1])

    val dp0 = nums[0]
    val dp1 = nums[0].coerceAtLeast(nums[1])
    val intArray = IntArray(nums.size)
    intArray[0] = dp0
    intArray[1] = dp1
    var max = dp1
    for (i in 2 until nums.size) {
        intArray[i] = intArray[i - 1].coerceAtLeast(intArray[i - 2] + nums[i])
        if (intArray[i] > max)
            max = intArray[i]
    }
    return max
}

