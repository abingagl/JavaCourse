package com.starter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/28
 */
public class Klass {
    private int id;
    private String name;

    public Klass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "Klass:" + students.toString();
    }
}

