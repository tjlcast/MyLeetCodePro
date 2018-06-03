package com.tjlcast.demo03;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * Created by tangjialiang on 2018/5/28.
 *
 * 扩展spring生命周期
 * 自定义配置文件读取工具
 */
public class CustomPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    private Properties props ;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        this.props = props ;
    }

    public Object getProperty(String key) {
        return props.get(key) ;
    }
}
