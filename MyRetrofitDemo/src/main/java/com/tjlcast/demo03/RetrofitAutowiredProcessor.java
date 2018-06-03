package com.tjlcast.demo03;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.logging.Logger;


/**
 * Created by tangjialiang on 2018/5/28.
 */
public class RetrofitAutowiredProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    private static Logger LOGGER = Logger.getLogger(RetrofitAutowiredProcessor.class.getName()) ;

    @Autowired
    private CustomPropertyPlaceholderConfigurer propertyPlaceholderConfigurer ;

    @Override
    public boolean postProcessAfterInstantiation(final Object bean, String beanName) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                HttpService httpService = field.getAnnotation(HttpService.class);
                if (httpService == null) {
                    return ;
                }
                createRetrofitService(bean, field, field.getType()) ;
            }
        });
        return super.postProcessAfterInstantiation(bean, beanName) ;
    }

    private void createRetrofitService(Object bean, Field field, Class clazz) throws IllegalAccessException {
        // 读取注解中的值
        HttpApi httpApi = (HttpApi) clazz.getAnnotation(HttpApi.class);
        String key = httpApi.value() ;
        if (StringUtils.isBlank(key)) {
            return ;
        }

        // 根据注解的key获得配置文件中的url
        Object value = propertyPlaceholderConfigurer.getProperty(key);
        if (value == null) {
            return ;
        }

        // 根据地址创建retrofit
        Object object = RetrofitBeanFactory.putBean(value.toString(), clazz, httpApi.interceptor());
        if (object == null) {
            return ;
        }

        field.setAccessible(true);
        field.set(bean, object) ;
    }
}
