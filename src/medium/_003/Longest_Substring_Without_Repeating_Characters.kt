package medium._003

import java.util.*
import kotlin.collections.HashSet

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */

/**
 * 返回最长子穿的长度
 */
fun lengthOfLongestSubstring(s: String): Int {
    // n是字符串的长度，是一个常量
    val n = s.length
    // 使用var定义为变量
    var ans = 0
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (allUnique(s, i, j)) {
                ans = Math.max(ans, j - i)
            }
        }
    }
    return ans
}

fun allUnique(s: String, start: Int, end: Int): Boolean {
    val hashSet: HashSet<Char> = HashSet();
    for (i in start until end) {
        val ch = s[i]
        // 如果HashSet中含有该元素，就返回false
        if (hashSet.contains(ch)) {
            return false
        }
        // 如果HashSet中不含有该元素，就添加到这个HashSet中
        hashSet.add(ch)
    }
    return true
}

fun main() {
    val input = Scanner(System.`in`)
    println("请输入字符串：")
    val string = input.next()
    println(lengthOfLongestSubstring(string))
}

