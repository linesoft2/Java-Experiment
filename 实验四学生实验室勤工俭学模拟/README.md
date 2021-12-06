# 实验四 学生实验室勤工俭学模拟

## 实验目的

掌握Java中类的定义；

掌握static final等修饰符的用法；

了解异常的使用方法，并在程序中根据输入情况做异常处理

## 核心代码

1. 遍历计算工资

```java
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
```

2. 计算应缴税费

```java
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
```

## 系统运行结果

```
张三的工资为：130640.0元
李四的工资为：65840.0元
```
## 感想

通过本次实验，更清楚的了解了面向对象思想，了解了实际工作中系统的编写过程，编写思路，有很多收获。
