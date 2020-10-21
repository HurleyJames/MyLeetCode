package basic;

/**
 * 将金额的数字转化为大写的中文汉字
 */
public class NumToChinese {
    private static final String[] UPNUM = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] INT = {"元", "拾", "佰", "仟", "万", "亿"};
    private static final String[] UNINT = {"角", "分", "厘"};

    public static void main(String[] args) {
        // Test
        System.out.println(new NumToChinese().toChinese("2312.123"));
        System.out.println(new NumToChinese().toChinese("0.123"));
    }


    public String toChinese(String str) {
        // 整数部分
        String integerStr;
        // 小数部分
        String decimalStr;
        // 如果输入的不是数字（数字以及小数点的正则表达式）
        if (!str.matches("^[0.0-9.0]+$")) {
            return "抱歉，输入数字不符合要求！";
        }

        // 0元的特殊情况，包括 0 | 0.0 | 0.00
        if ("0".equals(str) || "0.0".equals(str) || "0.00".equals(str)) {
            return "零元";
        }

        if (str.indexOf('.') > 0) {
            // 既有小数，又有整数的情况
            // 整数部分
            integerStr = str.substring(0, str.indexOf('.'));
            // 小数部分
            decimalStr = str.substring(str.indexOf('.') + 1);
        } else if (str.indexOf('.') == 0) {
            // 全是小数
            integerStr = "";
            // 截取掉首位的零
            decimalStr = str.substring(1);
        } else {
            integerStr = str;
            decimalStr = "";
        }

        // 如果超出计算能力
        if (integerStr.length() > 16) {
            return "超出计算能力！";
        }

        // 将字符串转换成数组的形式
        // 整数部分
        int[] integers = toIntArray(integerStr);
        // 小数部分
        int[] decimals = toIntArray(decimalStr);

        // 即首位为零开头的形式是不满足要求的，例如 0123
        if (integers.length > 1 && integers[0] == 0) {
            return "抱歉，输入数字不符合要求！";
        }

        // 是否到达万，因为到万之后的数字会以十万、百万、千万等以万结尾来称呼
        boolean isWan = isWan(integerStr);
        return getInteger(integers, isWan) + getDecimal(decimals);
    }

    /**
     * 字符串转化为整型数组
     *
     * @param num
     * @return
     */
    public static int[] toIntArray(String num) {
        // 创建一个数组空间，空间长度为字符串的长度
        int[] arr = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            // 将字符串的元素依次加入到数组中
            arr[i] = Integer.parseInt(num.substring(i, i + 1));
        }
        return arr;
    }

    /**
     * 判断数字是否到万
     *
     * @return
     */
    public static boolean isWan(String str) {
        int len = str.length();
        // 如果长度大于4，说明已经是比万大的数字
        if (len > 4) {
            String subInteger = "";
            // 如果长度大于8，说明已经是亿的数字
            if (len > 8) {
                // 截取前面的数字
                subInteger = str.substring(len - 8, len - 4);
            } else {
                // 如果大于4小于8，说明是万、十万、百万、千万的数字，则截取前面的数字
                subInteger = str.substring(0, len - 4);
            }
            return Integer.parseInt(subInteger) > 0;
        } else {
            return false;
        }
    }

    /**
     * 获取整数部分的大写
     *
     * @param integers
     * @param isWan
     * @return
     */
    public static String getInteger(int[] integers, boolean isWan) {
        StringBuffer sb = new StringBuffer();
        int length = integers.length;
        // 如果只有一个0
        if (length == 1 && integers[0] == 0) {
            return "";
        }

        for (int i = 0; i < length; i++) {
            String key = "";
            // 对单位依次进行转换
            if (integers[i] == 0) {
                if (length - i == 13) {
                    // 万亿
                    key = INT[4];
                } else if (length - i == 9) {
                    // 亿
                    key = INT[8];
                } else if (length - i == 5 && isWan) {
                    // 万
                    key = INT[4];
                } else if (length - i == 1) {
                    // 元
                    key = INT[0];
                }

                if (length - i > 1 && integers[i + 1] != 0) {
                    key += UPNUM[0];
                }
            }
            sb.append(integers[i] == 0 ? key : UPNUM[integers[i]] + INT[length - i - 1]);
        }
        return sb.toString();
    }

    /**
     * 获取小数部分的大写
     *
     * @param decimals
     * @return
     */
    public static String getDecimal(int[] decimals) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < decimals.length; i++) {
            // 角 分 厘
            if (i == 3) {
                break;
            }
            sb.append(decimals[i] == 0 ? "" : UPNUM[decimals[i]] + UNINT[i]);
        }
        return sb.toString();
    }
}
