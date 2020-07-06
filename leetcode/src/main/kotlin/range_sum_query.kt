/**
 * Created by hefuduo on 3/17/20.
 */

//检索区域的和

//解题思路sum(i,j) = sum(0,j) - sum(0, i-1)
/**
 * 重点:::
 * 1. 你可以假设数组不可变。
 * 2. 会多次调用 sumRange 方法。
 * @property nums IntArray
 * @constructor
 */

class NumArray(nums: IntArray) {
    private var nums2: IntArray

    init {
        if (nums.isEmpty())
            nums2 = IntArray(0)
        else {
            nums2 = IntArray(nums.size)
            nums2[0] = 0
            for (i in 1 until nums.size) {
                var temp = 0
                for (j in 0..i) {
                    temp += nums[j]
                }
                nums2[i] = temp
            }
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        return if (nums2.isEmpty())
            0
        else {
            if (i > 0)
                nums2[j] - nums2[i - 1]
            else
                nums2[j]
        }
    }
}

