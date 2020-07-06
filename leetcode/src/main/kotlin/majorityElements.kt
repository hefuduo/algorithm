/**
 * Created by hefuduo on 2/18/20.
 */

/**
 * 求众数 考虑为什么是 n/2?? 这个是题点.
 */
fun main() {
    println(majorityElement(intArrayOf(3, 2, 3)))
}

/**
 * 使用key value计数. 时间复杂度O(n) 空间复杂度O(n)
 * @param nums IntArray
 * @return Int
 */
fun majorityElement(nums: IntArray): Int {
    val half = nums.size / 2
    val hashMap: MutableMap<Int, Int> = HashMap()
    for (i in nums.indices) {
        if (hashMap.containsKey(nums[i])) {
            hashMap[nums[i]] = hashMap[nums[i]]!! + 1
        } else {
            hashMap[nums[i]] = 1
        }
    }
    for ((key, value) in hashMap) {
        if (value > half)
            return key
    }
    return 0
}

/**
 * 时间复杂度 O(nLongN) 空间复杂度 O(1)
 * 考虑先将数组排序, 那么众数肯定是 n/2或者是 n/2+ 1 (考虑奇偶数)
 * @param nums IntArray
 * @return Int
 */
fun majorityElement2(nums: IntArray): Int {
    nums.sort()
    return nums[nums.size / 2]
}


/**
 * boyer mooer 投票法
 */

fun majorityElement3(nums: IntArray): Int {
    var count = 1;
    var member = nums[0]
    for (i in 1 until nums.size) {
        if (count == 0) {
            //重置member
            member = nums[i]
            count = 1
            continue
        }
        if (member == nums[i])
            count++
        else
            count--
    }
    return member
}
