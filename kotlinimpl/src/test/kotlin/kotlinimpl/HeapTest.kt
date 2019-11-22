package kotlinimpl

import kotlin.test.Test


/**
 * kotlinimpl
 * Created by hefuduo on 2019-11-20.
 */
class HeapTest {

    @Test
    fun testBuildHeap() {
        var a: IntArray = intArrayOf(10, 1, 3, 67, 5, 9, 23, 10)
        val heap = Heap(a)
        heap.buildMinHeap()
        println(heap.toString())
    }
}
