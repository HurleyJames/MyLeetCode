package basic;

/**
 * 男女排队问题
 */
public class Lineup {

    /**
     * @param peoples string字符串
     * @return int整型
     */
    public int lineup(String peoples) {
        // write code here
        int numG = 0;
        int numB = 0;
        int len = peoples.length();
        char[] line = peoples.toCharArray();
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (line[i] == 'B') {
                numB = numB + i - k;
                k++;
            }
        }
        k = 0;
        for (int j = 0; j < len; j++) {
            if (line[j] == 'G') {
                numG = numG + j - k;
                k++;
            }
        }
        return numG > numB ? numB : numG;
    }
}
