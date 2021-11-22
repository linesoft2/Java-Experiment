# 实验三 继承关系

# 相比实验二的更改

1. Student类及Teacher类分别都有共用的属性id，name，gender，所以单独提取出来放在User类，并让这两个类继承自User类
2. 将main方法单独放在top.linesoft.biptstudy.app包中，User类放top.linesoft.biptstudy.user包中，在其余代码放在top.linesoft.biptstudy.system包中，所有类及使用的方法都设为public，以供其他类访问，将User类的构造方法分别设为protected，default，测试其是否可被访问。

## 实验目的

初步了解分析系统需求，从学生选课角度了解系统中的实体及其关系，学会定义类中的属性以及方法；

掌握面向对象的类设计方法（属性、方法）；

掌握通过构造方法实例化对象；

学会使用数组。

## 业务要求

1.编写上述实体类以及测试主类

2.在测试主类中，实例化多个类实体，模拟

1）教师开设某课操作；

2）学生选课操作、退课操作

3）打印学生课表信息（包括：编号、课程名称、上课地点、时间、授课教师等）

## 解题思路

1. 分别创建教师、学生、课程三个类

1. 创建一个OfferCourse类，包含课程和教师

2. 其中学生中创建一个

   ```java
   ArrayList<OfferCourse>
   ```

   （不使用数组因为数组不天然支持增删查改），用来表示学生所选的课程

3. 测试类中创建一个 

   ```java
   ArrayList<OfferCourse>
   ```
   
   用来表示当前系统中所有的可选的课程
   

## 核心代码

1. 教师开设课程操作

```java
   offerCourse.add(new OfferCourse( new Course(1,"Java","1705","周二上午8点")
                ,new Teacher(1, "张老师", "男")));
        offerCourse.add(new OfferCourse( new Course(1,"C语言","1906","周三上午8点")
                ,new Teacher(1, "王老师", "男")));
        offerCourse.add(new OfferCourse( new Course(1,"D语言","2006","周四上午8点")
                ,new Teacher(1, "赵老师", "男")));
        offerCourse.add(new OfferCourse( new Course(1,"E语言","2106","周五上午8点")
                ,new Teacher(1, "李老师", "男")));
```

2. 学生选课操作、退课操作

```java
   offerCourse.add(new OfferCourse( new Course(1,"Java","1705","周二上午8点")
                ,new Teacher(1, "张老师", "男")));
        offerCourse.add(new OfferCourse( new Course(1,"C语言","1906","周三上午8点")
                ,new Teacher(1, "王老师", "男")));
        offerCourse.add(new OfferCourse( new Course(1,"D语言","2006","周四上午8点")
                ,new Teacher(1, "赵老师", "男")));
        offerCourse.add(new OfferCourse( new Course(1,"E语言","2106","周五上午8点")
                ,new Teacher(1, "李老师", "男")));
```

3. 打印学生课表信息

```java
void printTimetable(){
        int i;
        for(i=0;i<course.size();i++){
            //包括：编号、课程名称、上课地点、时间、授课教师等
            System.out.println("编号："+course.get(i).course.id+"、课程名称："
                    +course.get(i).course.name+"、上课地点："
                    +course.get(i).course.place+"、时间："
                    +course.get(i).course.time+"、授课教师："
                    +course.get(i).teacher.name);
        }

    }
```

## 系统运行结果

```
编号：1、课程名称：Java、上课地点：1705、时间：周二上午8点、授课教师：张老师
编号：1、课程名称：C语言、上课地点：1906、时间：周三上午8点、授课教师：王老师
编号：1、课程名称：E语言、上课地点：2106、时间：周五上午8点、授课教师：李老师
```
## 感想

通过本次实验，更清楚的了解了面向对象思想，了解了实际工作中系统的编写过程，编写思路，有很多收获。
