package hard._004

fun brute(A: Array<Int>, B: Array<Int>): Double {
    var C: IntArray? = null
    C = IntArray(A.size + B.size)
    System.arraycopy(A, 0, C, 0, A.size)
    System.arraycopy(B, 0, C, A.size, B.size)
    val j = 0
    for (j in 0 until C.size ) {
        print(C[j])
    }
    return 0.0
}

fun main() {
    val A = arrayOf(1, 3)
    val B = arrayOf(2, 4)

    brute(A, B)
}