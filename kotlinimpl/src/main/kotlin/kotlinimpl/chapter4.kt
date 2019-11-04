package kotlinimpl

/**kotlinimpl 数据结构 之 树
 * Created by hefuduo on 2019-10-16.
 */

//二叉查找树的实现

/**
 * 二叉查找树
 * @param E : Comparable<E> 类型
 * @property root BinaryNode<E>? 树根
 */
class BinarySearchTree<E : Comparable<E>> {
    class BinaryNode<E>(
            var data: E? = null,
            var left: BinaryNode<E>? = null,
            var right: BinaryNode<E>? = null
    )

    var root: BinaryNode<E>? = null

    fun makeEmpty() {
        root = null
    }

    fun isEmpty(): Boolean {
        return root == null
    }

    fun contains(data: E): Boolean {
        return contains(data, root)
    }

    fun findMin(): E? {
        return findMin(root)
    }

    fun findMax(): E? {
        return findMax(root)
    }

    fun insert(data: E) {
        insert(data, root)
    }

    fun remove(data: E) {
        remove(data, root)
    }

    fun printTree() {

    }

    private fun contains(data: E, node: BinaryNode<E>?): Boolean {
        if (node == null)
            return false
        if (data == node.data) {
            return true
        } else if (data < node.data!!) {
            return contains(data, node.left)
        } else {
            return contains(data, node.right)
        }
    }

    private fun findMin(node: BinaryNode<E>?): E? {
        //递归的实现, 可以使用非递归
        return if (node?.left != null) {
            findMin(node.left)
        } else {
            node?.data
        }
    }

    private fun findMax(node: BinaryNode<E>?): E? {
        return if (node?.right != null)
            findMax(node.right)
        else
            node?.data
    }

    /**
     * 插入操作
     * @param data E
     * @param node BinaryNode<E>?
     */
    private fun insert(data: E, node: BinaryNode<E>?): BinaryNode<E>? {
        var p = node;
        if (p == null)
            p = BinaryNode<E>(data, null, null)
        when {
            data > p.data!! -> p.right = insert(data, p.right)
            data < p.data!! -> p.left = insert(data, p.left)
            else -> {
            }
        }
        return p;
    }

    private fun remove(data: E, node: BinaryNode<E>?): BinaryNode<E>? {
        if (node == null) {
            return node;
        }
        var p = node;
        when {
            data > p.data!! -> p.right = remove(data, p.right)
            data < p.data!! -> p.left = remove(data, p.left)
            else -> {
                if (p.right != null && p.left != null) { //复杂情况, 将要删除的点有两个子树的节点.
                    p.data = findMin(p.right)//找到右子树中最小值, 赋给将要被删除的点.
                    p.right = remove(p.data!!, p.right); // 将右子树中最小值删除
                } else {
                    p = if (p.left != null) p.left else p.right;
                }
            }
        }
        return p;
    }
}

