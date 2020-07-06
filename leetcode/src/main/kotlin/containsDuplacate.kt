/**
 * Created by hefuduo on 3/5/20.
 */
//存在重复元素

fun main(args: Array<String>) {

}

fun containsDuplicate(nums: IntArray): Boolean {
    val set: HashSet<Int> = HashSet()
    nums.forEach {
        if(set.contains(it)) {
            return@containsDuplicate true
        }else {
            set.add(it)
        }
    }
    return false
}
