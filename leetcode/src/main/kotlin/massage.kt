/**
 * Created by hefuduo on 3/17/20.
 */
//按摩师,跟小偷最大收益的题目是一个意思

fun main() {

}

fun massage(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return nums[0]
    if (nums.size == 2) return Math.max(nums[0], nums[1])
    var max = IntArray(nums.size)
    max[0] = nums[0]
    var temp = Math.max(nums[0], nums[1])
    max[1] = Math.max(nums[0], nums[1])
    for (i in 2 until nums.size) {
        max[i] = Math.max(max[i - 1], max[i - 2] + nums[i])
        if (max[i] > temp)
            temp = max[i]
    }
    return temp
}
