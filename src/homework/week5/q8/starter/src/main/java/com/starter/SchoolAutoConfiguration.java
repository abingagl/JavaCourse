package com.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/28
 */

@Configuration
@EnableConfigurationProperties(SchoolProperties.class)
@PropertySource("classpath:application.properties")
public class SchoolAutoConfiguration {
    @Autowired
    private SchoolProperties schoolProperties;

    @Bean
    public School school() {
        List<Integer> studentIds = schoolProperties.getStudentIds();
        List<String> studentNames = schoolProperties.getStudentNames();
        List<Integer> classIds = schoolProperties.getKlassIds();
        List<String> classNames = schoolProperties.getKlassNames();
        List<Map<String, Integer>> studentOfClass = schoolProperties.getStudentOfKlass();

        List<Student> students = new ArrayList<>(studentIds.size());
        for (int i=0; i<studentIds.size(); i++) {
            students.add(new Student(studentIds.get(i), studentNames.get(i)));
        }

        List<Klass> klasses = new ArrayList<>();
        for (int i=0; i<classIds.size(); i++) {
            klasses.add(new Klass(classIds.get(i), classNames.get(i)));
        }

        for (Map info: studentOfClass) {
            klasses.get((Integer) info.get("myClassId")).addStudent(students.get((Integer) info.get("studentId")));
        }

        System.out.println(studentIds.toString());
        System.out.println(studentNames.toString());
        System.out.println(classIds.toString());
        System.out.println(classNames.toString());
        System.out.println(studentOfClass.toString());

        return new School(klasses);
    }
}
