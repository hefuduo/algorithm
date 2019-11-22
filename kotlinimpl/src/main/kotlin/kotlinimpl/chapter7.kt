package kotlinimpl

/**kotlinimpl
 * Created by hefuduo on 2019-11-15.
 */
/*
排序算法
 */

/*
 #1. 插入排序 时间复杂度
 */
fun <T : Comparable<T>> insert1(a: Array<T>) {
    var temp: T;
    for (i in 1 until a.size) {
        temp = a[i]
        var p: Int = 0
        for (j in 0 until i) {
            if (a[i] <= a[j]) {
                p = j
                break
            }
        }
        for (k in i downTo p + 1) {
            a[k] = a[k - 1]
        }
        a[p] = temp
    }
    println(a.contentToString())
}

/**
 * 增强版 的插入排序
 * @param a IntArray
 */
fun insert(a: IntArray) {
    var temp = 0
    var j = 0
    for (i in 1 until a.size) {
        temp = a[i]
        j = i
        while (j > 0 && temp < a[j - 1]) { //一边移动 一边比较, 直到a[i]移动到正确的位置.
            a[j] = a[j - 1]
            j--
        }
        a[j] = temp//把这个语句放到while循环或者放到外面效果一致.
    }
}

/**
 * 冒泡排序 如果两个相邻元素顺序不对,则交换相邻元素, 每一趟下去, 都有一个元素上浮到最终位置.
 * 事件复杂度O(n^2)
 *
 */

fun bubbleSort(a: IntArray) {
    val n = a.size - 1
    var temp: Int
    for (i in n downTo 1) {
        for (k in 0 until i) {
            if (a[k] > a[k + 1]) {
                temp = a[k + 1]
                a[k + 1] = a[k]
                a[k] = temp
            }
        }
    }
}

/**
 * 依次找到最小的
 * 事件复杂度O(n^2)
 */

fun selectSort(a: IntArray) {
    val n = a.size - 1
    var p = 0
    var min: Int
    var temp: Int
    for (k in 0..n) {
        min = a[k]
        p = k
        for (i in k..n) {
            if (a[i] < min) {
                min = a[i]
                p = i;
            }
        }
        temp = a[k]
        a[k] = a[p]
        a[p] = temp
    }
}

//希尔排序
//最坏时间复杂度O(N^2)
/**
 * @see [insert]
 * @param a IntArray
 * gap 是希尔序列, 此外还有Hibbard序列 最坏时间复杂度为O(N^3/2)平均为O(N^5/4)
 * @link  <a href="https://blog.csdn.net/Foliciatarier/article/details/53891144">希尔排序的增量序列</a>
 */
fun shellSort(a: IntArray) {
    val n = a.size
    var j: Int
    var gap = n / 2
    while (gap > 0) {
        //从这里开始是一个插入排序, 都忙gap =1 的时候详见 insert
        for (i in gap until n) {
            val temp = a[i]
            j = i - gap
            while (j >= 0 && temp < a[j]) {
                a[j + gap] = a[j]
                a[j] = temp // 注意这条语句的位置,比较一次, 移动一次, 知道在正确的位置,或者移动到正确的位置, 再一次赋值.
                j -= gap
            }
        }
        gap /= 2
    }
}


//堆排序
/**
 * 堆:数组表示, a[i]的子树是a[2i + 1] and a[2i + 2], 堆在抽象上是一个完全二叉树
 * a[i] >= a[2i + 1] && a[i] >= a[2i + 2]
 *
 * @param a IntArray
 */
fun heapSort(a: IntArray) {
    fun left(index: Int): Int {
        return 2 * index + 1;
    }

    fun right(index: Int): Int {
        return 2 * index + 2;
    }

    fun parent(index: Int): Int {
        return if (index == 0) {
            -1
        } else {
            (index - 1) / 2;
        }
    }

    fun maxHeap(i: Int, w: Int) {
        val l = left(i)
        val r = right(i)
        var max = if (l <= w && a[l] > a[i]) l else i
        var temp = 0;
        max = if (r <= w && a[r] > a[max]) r else max
        if (max != i) {
            temp = a[max]
            a[max] = a[i]
            a[i] = temp
            maxHeap(max, w)
        }
    }

    fun buildMaxHeap(w: Int) {
        val n = parent(w)
        for (i in n downTo 0) {
            maxHeap(i, w)
        }
    }

    fun swap(i: Int, j: Int) {
        val temp = a[i]
        a[i] = a[j]
        a[j] = temp
    }

    for (j in a.size - 1 downTo 1) {
        buildMaxHeap(j)
        swap(0, j)
    }
}

//归并排序, 典型的分治算法

fun mergeSort(a: IntArray) {
    fun merge(a: IntArray, temp: IntArray, l: Int, c: Int, r: Int) {
        //l ~ center center + 1 ~ r
        var i = l
        var j = c + 1
        var p = i;
        while (i <= c && j <= r) {
            if (a[i] <= a[j]) {
                temp[p++] = a[i++]
            }
            if (a[i] > a[j]) {
                temp[p++] = a[j++]
            }
        }
        while (i <= c) {
            temp[p++] = a[i++]
        }
        while (j <= r) {
            temp[p++] = a[j++]
        }
        for (k in l..r) {
            a[k] = temp[k]
        }
    }

    fun sort(a: IntArray, temp: IntArray, l: Int, r: Int) {
        val center = (l + r) / 2
        if (l < r) {
            sort(a, temp, l, center)
            sort(a, temp, center + 1, r)
            merge(a, temp, l, center, r)
        }
    }

    val temp: IntArray = IntArray(a.size)
    sort(a, temp, 0, a.size - 1)
}


fun quickSort(a: IntArray) {

    fun sort(a: IntArray, l: Int, r: Int) {
        if (r - l < 1)
            return
        var i = l
        var j = r
        var temp = a[i]
        while (i < j) {
            while (a[j] >= temp && i < j)
                j--
            if (i < j) {
                a[i] = a[j]
                i++
            }
            while (a[i] <= temp && i < j)
                i++
            if (i < j) {
                a[j] = a[i]
                j--
            }
        }
        a[i] = temp
        sort(a, l, i - 1)
        sort(a, i + 1, r)
    }

    sort(a, 0, a.size - 1)
}
