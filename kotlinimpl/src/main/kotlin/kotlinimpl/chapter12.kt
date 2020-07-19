package kotlinimpl

import java.util.*

/**kotlinimpl
 * Created by hefuduo on 7/7/20.
 */
//红黑树  Java集合实现 TreeMap -> PrettyTreeMap.
// ███████████   ███████████  ███████████
//░░███░░░░░███ ░░███░░░░░███░█░░░███░░░█
// ░███    ░███  ░███    ░███░   ░███  ░  ████████   ██████   ██████
// ░██████████   ░██████████     ░███    ░░███░░███ ███░░███ ███░░███
// ░███░░░░░███  ░███░░░░░███    ░███     ░███ ░░░ ░███████ ░███████
// ░███    ░███  ░███    ░███    ░███     ░███     ░███░░░  ░███░░░
// █████   █████ ███████████     █████    █████    ░░██████ ░░██████
//░░░░░   ░░░░░ ░░░░░░░░░░░     ░░░░░    ░░░░░      ░░░░░░   ░░░░░░

class BlackRedTree<E : Comparable<E>> {

    inner class RedBlackNode<E>(var data: E?, var left: RedBlackNode<E>?, var right: RedBlackNode<E>?, var color: Int)

    var mRoot: RedBlackNode<E>? = null
    var mNullBlackNode: RedBlackNode<E>? = null

    init {
        mRoot = RedBlackNode(null, null, null, BLACK)
        mNullBlackNode = RedBlackNode(null, null, null, BLACK)
    }

    companion object {
        public const val BLACK = 1
        public const val RED = 0
    }


    fun insert(data: E): RedBlackNode<E>? {
        return null
    }

    fun delete(data: E): RedBlackNode<E>? {
        return null
    }


    private fun compare(item: E, blackNode: RedBlackNode<E>?): Int {
        if (blackNode == null)
            return 1
        else
            return item.compareTo(blackNode.data!!)
    }

    /**
     * TODO
     *
     * @param item
     * @param parent
     * @return
     */
    private fun rotate(item: E, parent: RedBlackNode<E>): RedBlackNode<E>? {
//        if (compare(item, parent) < 0) {
//            if (compare(item, parent.left) < 0) {
//                //parent.left = rotateWithLeft(parent.left)
//                return rotateWithLeftChild(parent.left)
//            } else {
//                //rotate with right  LR
//                //parent.left = rotateWithRight(parent.left)
//                return rotateWithRightChild(parent.left)
//            }
//        }else {
//            if (compare(item, parent.left) < 0) {
//                //rotate with left  RL
//            } else {
//                //rotate with left  RR
//            }
//        }
        return null
    }

    private var mCurrent: RedBlackNode<E>? = null
    private var mParent: RedBlackNode<E>? = null
    private var mGrand: RedBlackNode<E>? = null
    private var mGreat: RedBlackNode<E>? = null

    private fun handleOrient(item: E?) {
        //color 颜色转换
        mCurrent!!.color = RED
        mCurrent!!.left!!.color = BLACK
        mCurrent!!.right!!.color = BLACK

        if (mParent!!.color == RED) {
            mGrand!!.color = RED

        }
    }

    /**2
     * 层序打印树, 思路是使用队列, 或者链表, 一次将节点, 节点的左右子树入队, 下一次一次一个的出队.
     */
    fun printTreeInLevel(blackNode: RedBlackNode<E>?) {
        var queue: Queue<RedBlackNode<E>> = ArrayDeque<RedBlackNode<E>>()
        queue.add(blackNode)
        // 用于记录当前处理的结点
        var curBlackNode: RedBlackNode<E>?
        while (!queue.isEmpty()) {
            curBlackNode = queue.remove()
            println("${curBlackNode.data} is ${if (curBlackNode.color == 0) "red" else "black"}")
            if (curBlackNode.left != null) {
                queue.add(curBlackNode.left)
            }
            if (curBlackNode.right != null) {
                queue.add(curBlackNode.right)
            }
        }
    }
}
