package com.chf.dropwizard.util;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        set(applicationContext);
    }

    public static Object getBean(String beanName) {
        return applicationContext == null ? null
                : applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<T> beanClass) {
        return applicationContext == null ? null
                : applicationContext.getBean(beanClass);
    }

    public static Map<String, Object> getBeansWithAnnotation(
            Class<? extends Annotation> annotationType) {
        return applicationContext == null ? null
                : applicationContext.getBeansWithAnnotation(annotationType);
    }
    
    private static void set(ApplicationContext context) {
        applicationContext = context;
    }
}
