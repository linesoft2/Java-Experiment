package top.linesoft.biptstudy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

class User implements java.io.Serializable {
    int id;
    String name;
    String gender;

    User(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
}

class Teacher extends User {

    Teacher(int id, String name, String gender) {
        super(id, name, gender);
    }

}

class OfferCourse implements java.io.Serializable {
    Course course;
    Teacher teacher;

    OfferCourse(Course course, Teacher teacher) {
        this.course = course;
        this.teacher = teacher;
    }

    public String toString() {
        return "编号：" + this.course.id + "、课程名称：" + this.course.name + "、上课地点："
                + this.course.place + "、时间：" + this.course.time + "、授课教师："
                + this.teacher.name;
    }
}

class Student extends User {

    ArrayList<OfferCourse> course = new ArrayList<OfferCourse>();

    Student(int id, String name, String gender) {
        super(id, name, gender);
    }

    // 选择某课
    void selectCourse(OfferCourse offerCourse) {
        course.add(offerCourse);
    }

    // 退出某课
    void exitCourse(OfferCourse offerCourse) {
        course.remove(offerCourse);
    }

    void printTimetable() {
        int i;
        for (i = 0; i < course.size(); i++) {
            // 包括：编号、课程名称、上课地点、时间、授课教师等
            System.out.println(course.get(i).toString());
        }

    }
}

class Course implements java.io.Serializable {
    int id;
    String name;
    String place;
    String time;

    Course(int id, String name, String place, String time) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.time = time;
    }

}

public class Main {

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

        try {

            FileOutputStream fileOut = new FileOutputStream("D:/course.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(student1.course);
            out.close();
            fileOut.close();

            FileInputStream fileIn = new FileInputStream("D:/course.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            student1.course = (ArrayList<OfferCourse>) in.readObject();
            in.close();
            fileIn.close();
            student1.course.remove(1);
            System.out.println();
            student1.printTimetable();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
