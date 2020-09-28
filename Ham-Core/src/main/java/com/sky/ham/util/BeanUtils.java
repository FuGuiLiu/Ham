package com.sky.ham.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 */
public class BeanUtils {
    private static final String CONFIG_PATH = "applicationContent.xml";
    private static ApplicationContext applicationContext;

    static {
        applicationContext = new ClassPathXmlApplicationContext(CONFIG_PATH);
    }

    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}
