package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：n = 3
 * 输出： 5
 * 结果："((()))", "(())()", "(()())", "()(())", "()()()"
 */
public class GenerateParenthesis {
    static List<String> lists = new ArrayList<>();

    public static void main(String[] args) {
        generate(2);
        System.out.println("size: " + lists.size());
    }

    public static List<String> generate(int n) {
        if (n < 1) {
            return lists;
        }
        String str = "";
        // 左右括号数量是对应的，相等的
        dfs(str, lists, n, n);
        return lists;
    }

    public static void dfs(String str, List<String> lists, int left, int right) {
        if (left == 0 && right == 0) {
            lists.add(str);
            return ;
        }
        if (left > 0) {
            str = str + "(";
            dfs(str, lists, left - 1, right);
//            str = str.substring(0, str.length() - 1);
            System.out.println("字符串1：" + str);
        }
        if (right > left) {
            str = str + ")";
            dfs(str, lists, left, right - 1);
//            str = str.substring(0, str.length() - 1);
            System.out.println("字符串2：" + str);
        }
    }
}
