import util.TreeNode

/**
 * Created by hefuduo on 3/10/20.
 */

//翻转二叉树

fun main() {

}

fun invertTree(root: TreeNode?): TreeNode? {
    if(root == null)
        return null
    val temp = root.right
    root.right = root.left
    root.left = temp
    invertTree(root.left)
    invertTree(root.right)
    return root
}
