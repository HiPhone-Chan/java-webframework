//package com.chf.dropwizard.util;
//
//import java.lang.annotation.Annotation;
//import java.util.Map;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class SpringUtil {
//
//    private static ApplicationContext applicationContext;
//
//    static {
//        applicationContext = new ClassPathXmlApplicationContext(
//                new String[] { "spring.xml" });
//    }
//
//    public static Object getBean(String beanName) {
//        return applicationContext == null ? null
//                : applicationContext.getBean(beanName);
//    }
//
//    public static <T> T getBean(Class<T> beanClass) {
//        return applicationContext == null ? null
//                : applicationContext.getBean(beanClass);
//    }
//
//    public static Map<String, Object> getBeansWithAnnotation(
//            Class<? extends Annotation> annotationType) {
//        return applicationContext == null ? null
//                : applicationContext.getBeansWithAnnotation(annotationType);
//    }
//
//}
