package basic;

/**
 * 是否有重复的字符串
 */
public class RepeatedSubstring {

    public static void main(String[] args) {
        System.out.println(new RepeatedSubstring().repeatedSubstringPattern("abab"));
        System.out.println(new RepeatedSubstring().repeatedSubstringPattern("abcba"));
    }

    public boolean repeatedSubstringPattern (String s) {
        // write code here
        String str = s + s;
        int len = s.length();
        // 假如有重复的，则乘以两倍后，除去首尾元素，中间仍然会有原来的字符串
        // 例如，abab * 2 = abababab，则除去首尾元素后为bababa，仍然存在原有字符串abab
        // 相反，abcba * 2 = abcbaabcba，则除去首尾元素后为bcbaabcb，不存在abcba，不满足要求
        return str.substring(1, 2 * len - 1).contains(s);
    }
}
