package org.glob.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author me
 */
public class SpringFactory {
    private static ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("beans.xml");

    @SuppressWarnings({"unchecked"})
    public static <T> T getBean(String name, Class<T> clazz) {
        return (T)CONTEXT.getBean(name, clazz);
    }
}
