package top.linesoft.biptstudy.app;

import java.util.ArrayList;
import java.util.List;
import top.linesoft.biptstudy.system.*;

public class App {

    public static void main(String[] args) {
        List<OfferCourse> offerCourse = new ArrayList<OfferCourse>();

        // 教师开设课程操作
        offerCourse.add(new OfferCourse(new Course(1, "Java", "1705", "周二上午8点"), new Teacher(1, "张老师", "男")));
        offerCourse.add(new OfferCourse(new Course(1, "C语言", "1906", "周三上午8点"), new Teacher(1, "王老师", "男")));
        offerCourse.add(new OfferCourse(new Course(1, "D语言", "2006", "周四上午8点"), new Teacher(1, "赵老师", "男")));
        offerCourse.add(new OfferCourse(new Course(1, "E语言", "2106", "周五上午8点"), new Teacher(1, "李老师", "男")));

        // 学生选课操作、退课操作
        Student student1 = new Student(2, "张三", "男");
        student1.selectCourse(offerCourse.get(0));
        student1.selectCourse(offerCourse.get(1));
        student1.selectCourse(offerCourse.get(2));
        student1.selectCourse(offerCourse.get(3));
        student1.exitCourse(offerCourse.get(2));

        // 打印学生课表信息
        student1.printTimetable();
    }
}