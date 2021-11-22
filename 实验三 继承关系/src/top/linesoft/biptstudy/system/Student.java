package top.linesoft.biptstudy.system;

import java.util.ArrayList;
import java.util.List;
import top.linesoft.biptstudy.user.User;

public class Student extends User {

    List<OfferCourse> course = new ArrayList<OfferCourse>();

    public Student(int id, String name, String gender) {
        super(id, name, gender);
    }

    // 选择某课
    public void selectCourse(OfferCourse offerCourse) {
        course.add(offerCourse);
    }

    // 退出某课
    public void exitCourse(OfferCourse offerCourse) {
        course.remove(offerCourse);
    }

    public void printTimetable() {
        int i;
        for (i = 0; i < course.size(); i++) {
            // 包括：编号、课程名称、上课地点、时间、授课教师等
            System.out.println("编号：" + course.get(i).course.id + "、课程名称：" + course.get(i).course.name + "、上课地点："
                    + course.get(i).course.place + "、时间：" + course.get(i).course.time + "、授课教师："
                    + course.get(i).teacher.name);
        }

    }
}