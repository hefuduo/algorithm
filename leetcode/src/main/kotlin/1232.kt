import java.util.concurrent.atomic.AtomicInteger

/**
 * Created by hefuduo on 3/30/20.
 */
//title : 缀点成线

//content:

fun main() {
    val i = AtomicInteger()
    i.incrementAndGet()

}


fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
    if (coordinates.isEmpty())
        return false
    if (coordinates.size == 1 || coordinates.size == 2)
        return true
    //考虑特殊直线情况 这个不对.
    if (coordinates[1][0] == coordinates[0][0] || coordinates[1][1] == coordinates[0][1])
        return true
    //先把直线方程求出来
}
