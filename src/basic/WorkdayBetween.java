package basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WorkdayBetween {
    public static void main(String[] args) throws ParseException {
        System.out.println(new WorkdayBetween().workdays_between(2020,9,25,2020,9,28));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param y1 int整型 当前日期的年
     * @param m1 int整型 当前日期的月
     * @param d1 int整型 当前日期的日
     * @param y2 int整型 项目截止日期的年
     * @param m2 int整型 项目截止日期的月
     * @param d2 int整型 项目截止日期的日
     * @return int整型
     */
    public int workdays_between(int y1, int m1, int d1, int y2, int m2, int d2) throws ParseException {
        // write code here
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String day1 = y1 + "-" + m1 + "-" + d1;
        String day2 = y2 + "-" + m2 + "-" + d2;
        Date date1 = simpleDateFormat.parse(day1);
        Date date2 = simpleDateFormat.parse(day2);

        int days = (int) ((date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000));
        int weeks = days / 7;
        int between = 0;

        if (days % 7 == 0) {
            // delete weekend
            between = days - 2 + weeks;
        } else {
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(date1);
            c2.setTime(date2);
            int begin = c1.get(Calendar.DAY_OF_WEEK) - 1;
            int end = c2.get(Calendar.DAY_OF_WEEK) - 1;
            if (begin > end) {
                System.out.println("a" + begin + days);
                between = days - 2 * (weeks + 1);
            } else if (begin < end) {
                if (end == 7) {
                    System.out.println("b" + begin);
                    between = days - 2 * weeks - 1;
                } else {
                    System.out.println("c" + begin);
                    between = days - 2 * weeks;
                }
            } else {
                if (begin == 1 || begin == 7) {
                    System.out.println("d" + begin);
                    between = days - 2 * weeks - 1;
                } else {
                    System.out.println("e" + begin);
                    between = days - 2 * weeks;
                }
            }
        }
        return between;
    }
}
