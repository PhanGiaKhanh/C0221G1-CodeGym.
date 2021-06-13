package com.example;

import com.example.bean.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
//        vào resources lấy applicationContext.xml
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorldBean");
//        lấy id bean trong applicationContext.xml

        System.out.println(helloWorld.getMessage());
    }
}
