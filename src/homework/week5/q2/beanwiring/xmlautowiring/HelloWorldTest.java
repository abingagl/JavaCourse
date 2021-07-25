package homework.week5.q2.beanwiring.xmlautowiring;

import homework.week5.q2.beanwiring.HelloWorld;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author ：zhang
 * @title ：XML自动装配Bean
 * @date ：created in 2021/07/23
 */

public class HelloWorldTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanWiringXmlAutowire.xml");
        HelloWorld obj = context.getBean("helloWorld", HelloWorld.class);
        obj.say();
    }
}
