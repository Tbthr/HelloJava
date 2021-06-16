package programming;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class NewTimeAPI {
    public static void main(String[] args) throws InterruptedException {
        LocalDate now1 = LocalDate.now();
        System.out.println(now1.getYear()); //2020
        System.out.println(now1); //2020-06-12

        LocalTime now2 = LocalTime.now();
        System.out.println(now2);//11:02:28.138633300

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(now.format(f));//2020-06-12

        LocalDate of = LocalDate.of(2010, 12, 3);
        //判断一个日期是在另一个日期之前或之后
        boolean after = now1.isAfter(of);
        System.out.println(after);//true
        boolean before = now1.isBefore(of);
        System.out.println(before);//false

        //判断两个日期是否相同
        boolean equal = now1.isEqual(of);
        System.out.println(equal);//false
        //判断是不是闰年
        boolean leapYear = of.isLeapYear();
        System.out.println(leapYear);//false

        // 添加年月日时分秒的方法 plus系列的方法 都会返回一个新的LocalDateTime的对象
        //每次加完时间量，都会返回一个新的日期对象
        LocalDateTime localDateTime = now.plusDays(10);
        System.out.println(localDateTime);//2020-06-22T11:02:28.138633300
        LocalDateTime localDateTime1 = now.plusYears(2);
        System.out.println(localDateTime1);//2022-06-12T11:02:28.138633300

        //减去年月日时分秒的方法 minus 系列的方法 注意都会返回一个新的LocalDateTime的对象
        LocalDateTime localDateTime2 = now.minusYears(2);
        System.out.println(localDateTime2);//2018-06-12T11:02:28.138633300

        Instant now3 = Instant.now();
        long epochSecond = now3.getEpochSecond();//获取的秒值，从计算机元年到当前时刻
        System.out.println(epochSecond);//1591930948
        long l = now3.toEpochMilli();//获取的是毫秒值
        System.out.println(l);//1591930948143


        Instant start = Instant.now();
        Thread.sleep(2000);
        Instant end = Instant.now();
        //Duration 可以计算两个时间的间隔
        Duration between = Duration.between(start, end);
        long l1 = between.toMillis();
        System.out.println(l1);//2001毫秒

        LocalDate birthday = LocalDate.of(1995, 10, 10);
        LocalDate now4 = LocalDate.now();
        //Period 计算两个日期的间隔
        Period between1 = Period.between(birthday, now4);
        int years = between1.getYears();
        int months = between1.getMonths();
        int days = between1.getDays();
        System.out.println(between1);//P24Y8M2D
        System.out.println(years);//24
        System.out.println(months);//8
        System.out.println(days);//2
    }
}