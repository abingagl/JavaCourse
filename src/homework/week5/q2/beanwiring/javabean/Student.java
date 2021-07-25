package homework.week5.q2.beanwiring.javabean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/25
 */
class Student{
    private String name;
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
class Teacher{
    private Student student;
    public void setStudent(Student student){
        this.student=student;
    }
    public void say(){
        System.out.println(student.getName()+"，叫家长来一下。");
    }
}
@Configuration
class Config{
    @Value("张三JavaBean") String name;
    @Bean(name = "student")
    public Student student(){
        Student student=new Student();
        student.setName(name);
        return student;
    }
    @Bean(name = "teacher")
    public Teacher teacher(){
        Teacher teacher=new Teacher();
        teacher.setStudent(student());
        return teacher;
    }
}
