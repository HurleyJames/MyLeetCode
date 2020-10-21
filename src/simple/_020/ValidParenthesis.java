package simple._020;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 输入: "({[]})"
 * 输出: true
 */
public class ValidParenthesis {

    // TODO
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) {
            // 如果长度为奇数，说明肯定是不合法的
            return false;
        }

        // 使用哈希表存储每一种括号，键为右括号，值为左括号
        Map<Character, Character> pairs = new HashMap<>();
        // Map中预先添加括号的键值对
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        // 创建一个栈
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            // 获得字符串的每一个字符
            char ch = s.charAt(i);
            // 如果Map中有这个键，说明有这个右括号，则去栈中寻找一个相同的左括号
            if (pairs.containsKey(ch)) {
                // 如果栈为空，或者栈顶元素与该右括号匹配的左括号不相同（注意是栈顶，不是栈底）
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                // 否则，移除栈顶元素
                stack.pop();
            } else {
                // 如果Map中不含有这个右括号，说明当前字符ch是一个左括号，直接入栈
                stack.push(ch);
            }
        }
        // 上述过程中，入栈的只可能是左括号，所以如果有右括号跟它匹配，就会把左括号出栈；
        // 那么，当栈为空时，说明所有的左括号都找到了对应的右括号，所以返回的是stack.isEmpty()
        return stack.isEmpty();
    }
}