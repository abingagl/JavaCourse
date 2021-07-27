package com.starter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/28
 */
public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("id", id);
        map.put("name", name);
        return "Student::" + map.toString();
    }
}
