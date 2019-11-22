package kotlinimpl


import kotlin.test.*;
import kotlin.random.Random

/**
 * kotlinimpl
 * Created by hefuduo on 2019-10-12.
 */
class Chapter3KtTest {
    @BeforeTest
    fun setUp() {
    }

    @Test
    fun printLots() {
        val p = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val q = listOf(2, 4, 6, 8)
        printLots(p, q)
    }


    @Test
    fun switchWithNext() {
        val head: Node<Int>? = Node(0, null, null)
        var x = head
        var beforeP: Node<Int>? = null
        for (i in 1..9) {
            x?.next = Node(i, null, null)
            x = x?.next
            if (i == 5)
                beforeP = x
        }
        beforeP?.apply {
            println("beforeP is ${beforeP.item}")
            switchWithNext(beforeP)
        }
        head?.printList()
    }

    @Test
    fun switchWithNext2() {
        val head: Node<Int>? = Node(0, null, null)
        var x = head
        var beforeP: Node<Int>? = null
        for (i in 1..9) {
            x?.next = Node(i, null, x)
            x = x?.next
            if (i == 5)
                beforeP = x
        }
        beforeP?.apply {
            println("beforeP is ${beforeP.item}")
            switchWithNext2(beforeP)
        }
        head?.printList()
    }

    @Test
    fun interSection() {
        val l1 = listOf(1, 4, 5, 6, 7, 8, 10)
        val l2 = listOf(4, 7, 23, 24)
        val result = interSection(l1, l2)
        println(result)
    }

    @Test
    fun union() {
        val l1 = listOf(1, 4, 5, 6, 7, 8, 10)
        val l2 = listOf(4, 7, 23, 24)
        val result = union(l1, l2)
        println(result)
    }


    @Test
    fun sizeOfListTest() {

    }

    @Test
    fun bubbleSortTest() {
        val random = Random(20)
        val head = Node(random.nextInt(0, 100), null, null)
        var p = head
        for (i in 1..5) {
            p.next = Node(random.nextInt(0, 100), null, null)
            p = p.next!!
        }

        head.printList()
        bubbleSort(head)
        println("排序后")
        head.printList()
    }
}
