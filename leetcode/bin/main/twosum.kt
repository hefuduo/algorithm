
/**
 * Created by hefuduo on 2/3/20.
 */
fun main(args: Array<String>) {

}

/**
 * 两数之和, 暴力破解 or 一遍hash
 * [tag] 哈希表, java
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map[nums[i]] = i
    }
    throw IllegalArgumentException("No two sum solution");
}

