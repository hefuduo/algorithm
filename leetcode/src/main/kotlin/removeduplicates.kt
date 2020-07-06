/**
 * Created by hefuduo on 2/5/20.
 */

fun main(args: Array<String>) {

}

/*
从数组中移除相同的项目,并且控件复杂度为O(1)
 */

/**
 * 快慢指针法
 * @param nums IntArray
 * @return Int
 */
fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty())
        return 0
    var p: Int = 0 //慢指针
    var q: Int = 1 //快指针
    while (q < nums.size) {
        if (nums[p] != nums[q]) {
            nums[p + 1] = nums[q]
            p++
        }
        q++
    }
    return p + 1
}
