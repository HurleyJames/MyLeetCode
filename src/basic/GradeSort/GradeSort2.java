package basic.GradeSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 成绩排序
 */
public class GradeSort2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Student> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(new Student(scanner.nextInt(), scanner.nextInt()));
        }
        Collections.sort(lists);
        for (Student student : lists) {
            System.out.println(student);
        }
    }
}

class Student implements Comparable<Student> {
    Integer id;
    Integer score;

    public Student(Integer id, Integer score) {
        this.id = id;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.score.equals(o.score) ? id.compareTo(o.id) : score.compareTo(o.score);
    }

    @Override
    public String toString() {
        return id + ", " + score;
    }
}
