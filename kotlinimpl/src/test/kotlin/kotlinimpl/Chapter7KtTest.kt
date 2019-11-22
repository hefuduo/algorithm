package kotlinimpl

import org.junit.Test

/**
 * kotlinimpl
 * Created by hefuduo on 2019-11-16.
 */
class Chapter7KtTest {
    private val array = intArrayOf(10, 23, 4 ,5 ,6 , 78, 3, 4 ,1)

//    @Test
//    fun insert1Test() {
//        insert1<Int>(arrayOf(10, 4, 5, 6, 7, 3, 2))
//
//    }
//
//    @Test
//    fun insertTest() {
//        insert(array)
//        print(array.contentToString())
//    }
//
//    @Test
//    fun bubbleSortTest() {
//        bubbleSort(array)
//        print(array.contentToString())
//    }
//
//    @Test
//    fun selectSortTest() {
//        selectSort(array)
//        println(array.contentToString())
//    }
//
//    @Test
//    fun shellSortTest() {
//        shellSort(array)
//        println(array.contentToString())
//    }
//
//    @Test
//    fun heapSortTest() {
//        heapSort(array)
//        println(array.contentToString())
//    }

    @Test
    fun mergeSort() {
        kotlinimpl.mergeSort(array)
        println("mergeSort")
        println(array.contentToString())
    }

    @Test
    fun quickSort() {
        kotlinimpl.quickSort(array)
        println("quickSort")
        println(array.contentToString())
    }
}
