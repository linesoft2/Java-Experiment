# 实验六 文件输入输出 

## 实验目的

掌握文件输入输出；

掌握对象序列化方法。

## 业务要求

在实验三（学生选课模拟系统）的基础上，利用文件保存选课结果，过程如下：

1. 采用对象序列化的writeObject方法把选课结果存到硬盘文件系统中；

2. 采用对象序列化的readObject方法从文件中恢复对象，并操作学生的选课课表，实现退课操作。

3. 打印课程对象信息，采用覆盖定义toString()方法的方式。

## 解题思路

1. 将Course，OfferCourse及User类实现java.io.Serializable接口以准备序列化。

2. 使用ObjectOutputStream及ObjectInputStream将相关对象序列化及反序列化。

## 核心代码

序列化及反系列化

```java
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
```

## 感想

通过本次实验，学到了对象的序列化及输入输出流的使用。
