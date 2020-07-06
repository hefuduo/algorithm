/**
 * Created by hefuduo on 3/9/20.
 */
//杨辉三角

fun main() {
    val r = generate(5)
    println(r)
}


fun generate(numRows: Int): List<List<Int>> {
    if (numRows == 0) {
        return arrayListOf()
    }
    val r = ArrayList<List<Int>>()
    val f1 = ArrayList<Int>()
    f1.add(1)
    r.add(f1)
    if (numRows == 1) {
        return r
    }
    val f2 = ArrayList<Int>()
    f2.add(1)
    f2.add(1)
    r.add(f2)
    if (numRows == 2) {
        return r
    }
    var i = 3
    var temp = r.last()
    while (i <= numRows) {
        val temp2 = ArrayList<Int>(temp.size + 1)
        temp2.add(temp[0])
        for (j in 1 until temp.size) {
            temp2.add(temp[j] + temp[j - 1])
        }
        temp2.add(temp.last())
        i++
        r.add(temp2)
        temp = r.last()
    }
    return r
}
