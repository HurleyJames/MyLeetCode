class Convert {
    fun find(A: IntArray, B: IntArray): Double {
        var C: IntArray? = null
        C = IntArray(A.size + B.size)
        System.arraycopy(A, 0, C, 0, A.size)
        System.arraycopy(B, 0, C, A.size, B.size)
        return 0.0
    }
}