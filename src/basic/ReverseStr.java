package basic;

/**
 * 反转字符串
 */
public class ReverseStr {
    public static void main(String[] args) {
        System.out.println(reverse("1234ab"));
    }

    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1) {
            return originStr;
        }
//        System.out.println(originStr.substring(1));
//        System.out.println(originStr.charAt(0));
        // 递归截取第一个字符，然后递归依次相加
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}
