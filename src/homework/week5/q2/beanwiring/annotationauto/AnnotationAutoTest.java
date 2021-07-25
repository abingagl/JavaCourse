package homework.week5.q2.beanwiring.annotationauto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/25
 */
public class AnnotationAutoTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanWiringAnnotationAuto.xml");
        // 获取UserController实例
        UserController userController = (UserController) applicationContext.getBean("userController");
        // 调用UserController中的save()方法
        userController.save();
    }
}
