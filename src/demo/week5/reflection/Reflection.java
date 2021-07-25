package demo.week5.reflection;

import java.lang.reflect.Field;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/22
 */
public class Reflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);

        Class stdClass = Student.class;
        System.out.println("field: " + stdClass.getField("score"));
        System.out.println("field: " + stdClass.getField("name"));
        System.out.println("field: " + stdClass.getDeclaredField("grade"));

        Object p = new Student(12, 23);
        Class pc = p.getClass();
        Field s = pc.getDeclaredField("score");
        System.out.println("score: " + s.get(p));

        Field g = pc.getDeclaredField("grade");
        g.setAccessible(true);
        System.out.println("grade: " + g.get(p));

        Student stu = new Student(0, 99);
        g.set(stu, 100);
        System.out.println("grade: " + g.get(stu));
    }
    private static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple Class name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("pacakge name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());


    }
}

class Student extends Person {
    public int score;
    private int grade;

    Student(int score, int grade) {
        this.score = score;
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }
}

class Person {
    public String name;
}

