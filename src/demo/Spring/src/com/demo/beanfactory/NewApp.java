package com.demo.beanfactory;

import com.demo.hello.HelloWorld;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/25
 */
public class NewApp {
    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
        HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
        System.out.println(obj.getMessage());

    }
}
