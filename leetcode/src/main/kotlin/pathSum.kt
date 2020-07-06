import util.TreeNode

/**
 * Created by hefuduo on 3/10/20.
 */

//路径总和

fun main() {

}


fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
    if (root == null)
        return false
    var SUM = sum
    SUM -= root.`val`

    if (root.left == null && root.right == null) {
        return SUM == 0
    } else
        return hasPathSum(root.left, SUM) || hasPathSum(root.right, SUM)
}
