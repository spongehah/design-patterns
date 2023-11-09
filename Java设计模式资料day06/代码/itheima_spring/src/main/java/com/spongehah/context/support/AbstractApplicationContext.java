package com.spongehah.context.support;

import com.spongehah.beans.factory.support.BeanDefinitionReader;
import com.spongehah.beans.factory.support.BeanDefinitionRegistry;
import com.spongehah.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractApplicationContext implements ApplicationContext {
    
    protected BeanDefinitionReader beanDefinitionReader;
    
    protected static Map<String, Object> singletonObjects = new HashMap<>();
    
    protected String configLocation;

    @Override
    public void refresh() throws Exception {
        //加载BeanDefinition对象
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        //初始化bean
        finishBeanInitialization();
    }

    private void finishBeanInitialization() throws Exception {
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            //这里使用getBean只是为了初始化Bean对象，不需要获取返回值（因为ApplicationContext是非延迟加载）
            getBean(beanDefinitionName);
        }
    }
}
