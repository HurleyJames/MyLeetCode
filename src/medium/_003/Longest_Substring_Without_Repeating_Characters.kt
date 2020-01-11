package medium._003

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */

/**
 * 1.暴力法
 * 返回最长子串的长度
 */
fun lengthOfLongestSubstring1(s: String): Int {
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

/**
 * 2.滑动窗口
 * 返回最长子串的长度
 */
fun lengthOfLongestSubstring2(s: String): Int {
    val n = s.length
    val set: HashSet<Char> = HashSet()
    // 默认长度为0，i和j从0开始向右移
    var ans = 0
    var i = 0
    var j = 0
    while (i < n && j < n) {
        if (!set.contains(s[j])) {
            set.add(s[j++])
//            print(set)
            ans = Math.max(ans, j - i)
        } else {
            set.remove(s[i++])
        }
    }
    return ans
}

/**
 * 3.优化的滑动窗口
 * 返回最长子串的长度
 */
fun lengthOfLongestSubstring3(s: String): Int {
    val n = s.length
    var ans = 0
    var i = 0
    var j = 0
    val map: HashMap<Char, Int> = HashMap()
    for (j in 0 until n) {
        if (map.containsKey(s[j])) {
            i = Math.max(map.getValue(s[j]), i)
            println(s[j])
            println(map.getValue(s[j]))
        }
        ans = Math.max(ans, j - i + 1)
        map.put(s[j], j + 1)
    }
    return ans
}

fun allUnique(s: String, start: Int, end: Int): Boolean {
    val hashSet: HashSet<Char> = HashSet()
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
    println(lengthOfLongestSubstring1(string))
    println(lengthOfLongestSubstring2(string))
    println(lengthOfLongestSubstring3(string))
}

