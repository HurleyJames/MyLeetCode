package basic;

/**
 * 男女排队问题
 * 幼儿园有n个小朋友排为一个队伍，男生用“B”表示，女生用“G”表示。
 * 当男女同挨着时便会发生矛盾。需要对所排的队伍进行调整，每次调整只能让相邻的小朋友交换位置。
 * 现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以让上述情况最少。
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
        // 将字符串转化为字符数组
        char[] line = peoples.toCharArray();
        int k = 0;
        for (int i = 0; i < len; i++) {
            // 每次都移动B，将所有的B移到前面，G移到后面
            if (line[i] == 'B') {
                // 将B移动到前面所需要的次数
                numB = numB + i - k;
                k++;
            }
        }
        k = 0;
        for (int j = 0; j < len; j++) {
            // 每次都移动G，将所有的G移到前面，B移到后面
            if (line[j] == 'G') {
                // 将G移动到前面所需要的次数
                numG = numG + j - k;
                k++;
            }
        }
        // 判断移动G和移动B哪个次数最少，返回最少的次数
        return numG > numB ? numB : numG;
    }
}
