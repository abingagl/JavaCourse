package homework.week5.q2.beanwiring.javabean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：zhang
 * @title ：配置类
 * @date ：created in 2021/07/25
 */

public class StudentTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Config.class);
        Teacher teacher=applicationContext.getBean("teacher",Teacher.class);
        teacher.say();
    }
}
