package homework.week5.q2.beanwiring.annotation;

import homework.week5.q2.beanwiring.Teacher;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author ：zhang
 * @title ：XML装配Bean
 * @date ：created in 2021/07/23
 */

public class StudentTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanWiringAnnotation.xml");
        Teacher teacher = context.getBean("teacher",Teacher.class);
        teacher.say();
    }
}
