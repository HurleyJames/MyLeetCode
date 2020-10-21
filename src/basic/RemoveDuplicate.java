package basic;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicate {
    public static void main(String[] args) {

    }

    /**
     * 删除重复元素
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] removeDuplicate(int[] array) {
        // write code here
        int len = array.length;
        List<Integer> lists1 = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (!lists1.contains(array[i])) {
                lists1.add(array[i]);
            } else {
                lists1.remove(array[i]);
                lists1.add(array[i]);
            }
        }
        return lists1.stream().mapToInt(Integer::valueOf).toArray();
    }
}
