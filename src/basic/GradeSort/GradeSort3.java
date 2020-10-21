package basic.GradeSort;

import java.util.*;

/**
 * 成绩排序，包括学号，成绩，姓名
 */
public class GradeSort3 {

    public static void main(String[] args) {
        // 生成1-100内的随机数作为成绩，成绩list
        List<Integer> lists = new ArrayList<>();
        // 学号list
        List<String> strLists = new ArrayList<>();

        Random random = new Random();
        while (lists.size() < 100) {
            int num = random.nextInt(101);
            if (!lists.contains(num) && num != 0) {
                lists.add(num);
                if (num < 10) {
                    strLists.add("Leeds20200" + num);
                } else {
                    strLists.add("Leeds2020" + num);
                }
            }
        }
        // 为成绩list排序（升序）
        Collections.sort(lists);

        Map<Integer, Grade> map = new HashMap<>();
        String name = "test";
        for (int i = 1; i <= 100; i++) {
            map.put(i - 1, new Grade(strLists.get(i - 1), lists.get(i - 1), name));
        }
        for (int j = 1; j <= 100; j++) {
            System.out.println(map.get(j - 1).toString());
        }
    }

}

class Grade {
    String id;
    int grade;
    String name;

    public Grade(String id, int grade, String name) {
        this.id = id;
        this.grade = grade;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                '}';
    }
}
