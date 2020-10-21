package basic.GradeSort;

import java.util.*;

/**
 * 成绩排序
 */
public class GradeSort1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            // 创建TreeMap存储数据
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                map.put(input.nextInt(), input.nextInt());
            }
            // 将TreeMap转成List存储
            List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    if (o2.getValue() > o1.getValue()) {
                        return -1;
                    } else if (o2.getValue().equals(o1.getValue())) {
                        // TreeMap默认是键升序排列
                        return o2.getKey() > o1.getKey() ? -1 : 1;
                    }
                    return 1;
                }
            });
            for (Map.Entry<Integer, Integer> mapping : list) {
                System.out.println(mapping.getKey() + ", " + mapping.getValue());
            }
        }
    }

}
