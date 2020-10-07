package basic;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ASCIISort {
    public static void main(String[] args) {
        String str = "123assume345contribute&*(){}&^%$#\\n@@";
        str = replaceString(str);
        System.out.println(ASCIISort(str));
    }

    public static String replaceString(String str) {
        // 运用正则表达式
        String regEx = "[\\n`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";

        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        String string = "";
        string = m.replaceAll(string).trim();
        System.out.println(string);
        return string;
    }

    public static String ASCIISort(String str) {
        // 将字符串拆分成一个个字符
        char[] test = new char[str.length()];
        StringBuilder sb = new StringBuilder();
        while (true) {
            String a = str;
            for (int i = 0; i < str.length(); i++) {
                test[i] = a.charAt(i);
            }
            // 数组排序
            Arrays.sort(test);
            for (int i = 0; i < test.length; i++) {
                // 添加会StringBuilder里
                sb.append(test[i]);
            }
            // trim()是用来删除字符串的首尾空白符
            String trim = sb.toString().trim();
            return trim;
        }
    }
}
