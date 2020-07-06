/**
 * Created by hefuduo on 3/5/20.
 */





fun main(args: Array<String>) {
}


fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    if (k >= nums.size)
        return false
    for (i in nums.indices) {
        if (i + k < nums.size) {
            if (nums[i] == nums[i + k])
                return true
        }
    }
    return false
}
