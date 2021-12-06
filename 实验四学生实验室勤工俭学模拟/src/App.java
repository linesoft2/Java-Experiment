import java.util.ArrayList;
import java.util.List;

class Lab {
    String name;

    Lab(String name) {
        this.name = name;
    }
}

class Student {
    String name;
    List<Lab> lab;
    double wages;

    Student(String name, List<Lab> lab) {
        this.name = name;
        this.lab = lab;
    }

    void addWages(double wages) {
        this.wages = this.wages + wages;
    }
}

class CheckBean {
    Lab lab;
    String check;

    CheckBean(Lab lab, String check) {
        this.lab = lab;
        this.check = check;
    }
}

class Record {
    List<CheckBean> record;
    List<Student> students;

    void addRecord(Lab lab, String check) {
        if (record == null) {
            record = new ArrayList<CheckBean>();
        }
        record.add(new CheckBean(lab, check));
    }

    void addStudent(Student student) {
        if (students == null) {
            students = new ArrayList<Student>();
        }
        students.add(student);
    }

    void calcWages() {
        CheckBean mRecord;
        Student mStudent;
        Lab mLab;
        for (int i = 0; i < record.size(); i++) {
            mRecord = record.get(i);
            for (int j = 0; j < students.size(); j++) {
                mStudent = students.get(j);
                for (int k = 0; k < mStudent.lab.size(); k++) {
                    mLab = mStudent.lab.get(k);
                    if (mLab == mRecord.lab) {
                        mStudent.addWages(Utils.check2wages(mRecord.check));
                    }
                }
            }

        }
        for (int j = 0; j < students.size(); j++) {
            mStudent = students.get(j);
            mStudent.wages = Utils.calcTax(mStudent.wages);
        }
    }
}

class Utils {
    public static double calcTax(double wages) {
        if (wages < 5000) {
            return 0;
        } else if (wages < 12000) {
            return wages * 0.1 - 210;
        } else if (wages < 25000) {
            return wages * 0.2 - 1410;
        } else if (wages < 35000) {
            return wages * 0.25 - 2660;
        } else if (wages < 55000) {
            return wages * 0.3 - 4410;
        } else if (wages < 80000) {
            return wages * 0.35 - 7160;
        } else {
            return wages * 0.45 - 15160;
        }
    }

    public static double check2wages(String check) {
        if (check.equals("优")) {
            return 10000;
        } else if (check.equals("及格")) {
            return 8000;
        } else {
            return 0;
        }
    }
}

public class App {
    public static void main(String[] args) {
        Lab lab1 = new Lab("计算机网络实验室");
        Lab lab2 = new Lab("组成原理实验室");
        List<Lab> labList1 = new ArrayList<Lab>();
        labList1.add(lab1);
        labList1.add(lab2);
        List<Lab> labList2 = new ArrayList<Lab>();
        labList2.add(lab1);
        Student stu1 = new Student("张三", labList1);
        Student stu2 = new Student("李四", labList2);
        Record record = new Record();
        record.addStudent(stu1);
        record.addStudent(stu2);
        for (int i = 0; i < 18; i++) {
            record.addRecord(lab1, "优");
            record.addRecord(lab2, "及格");
        }
        record.calcWages();
        System.out.println(stu1.name + "的工资为：" + stu1.wages + "元");
        System.out.println(stu2.name + "的工资为：" + stu2.wages + "元");
    }

}
