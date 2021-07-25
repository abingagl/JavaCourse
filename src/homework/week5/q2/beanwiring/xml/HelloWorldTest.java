package homework.week5.q2.beanwiring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author ：zhang
 * @title ：XML装配Bean
 * @date ：created in 2021/07/23
 */

public class HelloWorldTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanWiringXml.xml");

        // property
        homework.week5.q2.beanwiring.HelloWorld obj = (homework.week5.q2.beanwiring.HelloWorld) context.getBean("helloWorld");
        System.out.println(obj.getMessage());

        // constructor
        homework.week5.q2.beanwiring.HelloWorld obj2 = (homework.week5.q2.beanwiring.HelloWorld) context.getBean("helloWorld2");
        System.out.println(obj2.getMessage());
    }
}
