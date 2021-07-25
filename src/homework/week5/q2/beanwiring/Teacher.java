package homework.week5.q2.beanwiring;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/25
 */
public class Teacher{
    @Autowired
    private Student student;
    public void say(){
        System.out.println(student.getName()+"，叫家长来一下。");
    }
}
