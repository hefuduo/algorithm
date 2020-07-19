package kotlinimpl

import com.sun.jmx.remote.internal.ArrayQueue
import java.util.*
import kotlin.math.max

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

/*
 *  AVL 树
 */


class AvlNode<E : Comparable<E>>(var data: E?, var left: AvlNode<E>?, var right: AvlNode<E>?, var height: Int)

class AvlTree<E : Comparable<E>> {
    var root: AvlNode<E>? = null

    /**
     * 获取height
     * @param node AvlNode<E>?
     * @return Int
     */
    private fun height(node: AvlNode<E>?): Int {
        return node?.height ?: -1
    }

    /**
     * rotate binary tree with left child.
     * For avl trees, this is a single rotation.
     * Update heights, then return new root.
     * 单旋转 右旋
     * @param node AvlNode<E>? root node to be rotated
     */
    private fun rotateWithLeftChild(k2: AvlNode<E>): AvlNode<E>? {
        val k1 = k2.left
        k2.left = k1?.right
        k1?.right = k2;
        //更新height
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1?.height = max(k2.height, height(k1?.left)) + 1;
        return k1
    }

    /**
     * the mirror of [rotateWithLeftChild]
     * @param k2 AvlNode<E>
     * @return AvlNode<E>?
     */
    private fun rotateWithRightChild(k2: AvlNode<E>): AvlNode<E>? {
        val k1 = k2.right;
        k2.right = k1?.left
        k1?.left = k2;
        //更新height
        k2.height = max(height(k2.left), height(k2.right)) + 1
        k1?.height = max(k2.height, height(k1?.right)) + 1
        return k1;
    }

    /**
     *
     * @param k3 AvlNode<E>
     * @return AvlNode<E>?
     * 先左旋,然后右旋转
     */
    private fun doubleWithLeftChild(k3: AvlNode<E>): AvlNode<E>? {
        if (k3.left != null) {
            k3.left = rotateWithRightChild(k3.left!!);
        }
        return rotateWithLeftChild(k3)
    }

    /**
     * mirror operation of [doubleWithLeftChild]
     * @param k3 AvlNode<E>
     * @return AvlNode<E>?
     * 先右旋, 然后左旋.
     */
    private fun doubleWithRightChild(k3: AvlNode<E>): AvlNode<E>? {
        if (k3.right != null) {
            k3.right = rotateWithLeftChild(k3.right!!)
        }
        return rotateWithRightChild(k3)
    }


    fun insert(data: E) {
        insert(data, root)
    }

    val ALLOWED_IMBALANCE = 1 //允许的左右子树的高度差!!! 平衡条件.

    /**
     * 平衡 这个才是平衡二叉树(AVLTree)的最精髓的地方=>如何保证一个点的左右子树是平衡的
     * @param avlNode AvlNode<E>
     * @return AvlNode<E>?
     */
    private fun balance(t: AvlNode<E>): AvlNode<E>? {
        //如果左边大于右边 右旋转
        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
            if (height(t.left?.left) >= height(t.left?.right)) {
                rotateWithLeftChild(t)
            } else {
                doubleWithLeftChild(t)
            }
        } else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
            if (height(t.right?.right) >= height(t.right?.left)) {
                rotateWithRightChild(t)
            } else {
                doubleWithRightChild(t)
            }
        }
        t.height = max(height(t.left), height(t.right)) + 1
        return t
    }


    private fun insert(data: E, node: AvlNode<E>?): AvlNode<E>? {
        var p: AvlNode<E>? = node ?: return AvlNode<E>(data, null, null, 0);
        p?.apply {
            when {
                data > this.data!! -> this.right = insert(data, this.right)
                data < this.data!! -> this.left = insert(data, this.left)
                else -> {
                }
            }
            p = balance(this)
        }
        return p;
    }

    private fun remove(data: E, node: AvlNode<E>?): AvlNode<E>? {

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
        return p?.let { balance(it) };

    }

    private fun findMin(node: AvlNode<E>?): E? {
        //递归的实现, 可以使用非递归
        return if (node?.left != null) {
            findMin(node.left)
        } else {
            node?.data
        }
    }


    /**2
     * 层序打印树, 思路是使用队列, 或者链表, 一次将节点, 节点的左右子树入队, 下一次一次一个的出队.
     */
    fun printTreeInLevel(node: AvlNode<E>?) {
        var queue: Queue<AvlNode<E>> = ArrayDeque<AvlNode<E>>()
        queue.add(node)
        // 用于记录当前处理的结点
        var curNode: AvlNode<E>?
        while (!queue.isEmpty()) {
            curNode = queue.remove()
            println(curNode.data)
            if (curNode.left != null) {
                queue.add(curNode.left)
            }
            if (curNode.right != null) {
                queue.add(curNode.right)
            }
        }
    }

}

/**
 * 伸展树 在第十二章高级数据结构中讲解
 */






