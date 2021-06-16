package programming.Comparable_Comparator;

import java.util.*;

/*
输入：
小明,2001,Java,88
小刚,2002,Java,78
小丁,2003,Java,56
小宏,2004,Java,85
小明,2001,Python,84
小刚,2002,Python,98
小丁,2003,JavaWeb,66
小宏,2004,Algorithm,87
exit

输出：
No1:2002,小刚
No2:2001,小明
No3:2004,小宏
No4:2003,小丁

按照学生平均成绩降序排序（平均成绩相同的学号小的在前面）的学生排名（具体输出格式参照样例）。
*/
public class Student {
    private final String name;
    private final String number;
    private final String course;
    private final double score;

    @Override
    public String toString() {
        return number + "," + name;
    }

    public Student(String name, String number, String course, double score) {
        this.name = name;
        this.number = number;
        this.course = course;
        this.score = score;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String s;
        do {
            s = in.nextLine();
            if (s.equals("exit")) break;
            else list.add(s);
        } while (true);
        Collections.sort(list);

        List<Student> stuList = new ArrayList<>();
        int listSize = list.size();
        for (int i = 0; i < listSize - 1; i++) {
            String[] split = list.get(i).split(",");
            int score = Integer.parseInt(split[3]);
            int sum = 1;
            while (true) {
                String[] split1;
                if (i + 1 < listSize - 1) {
                    split1 = list.get(i + 1).split(",");
                } else {
                    break;
                }
                if (split1[0].equals(split[0])) {
                    score += Integer.parseInt(split1[3]);
                    sum++;
                    i++;
                } else break;
            }
            stuList.add(new Student(split[0], split[1], split[2], score * 1.0 / sum));
        }

        stuList.sort((o1, o2) -> {
            if (o1.score != o2.score) {
                return -Double.compare(o1.score, o2.score);
            } else {
                return o1.course.compareTo(o2.course);
            }
        });

        for (int i = 0; i < stuList.size(); i++) {
            System.out.print("No" + (i + 1) + ":");
            System.out.println(stuList.get(i));
        }
    }
}
