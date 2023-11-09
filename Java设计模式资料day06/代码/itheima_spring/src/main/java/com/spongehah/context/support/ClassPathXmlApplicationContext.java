package com.spongehah.context.support;

import com.spongehah.beans.BeanDefinition;
import com.spongehah.beans.MutablePropertyValues;
import com.spongehah.beans.PropertyValue;
import com.spongehah.beans.factory.support.BeanDefinitionRegistry;
import com.spongehah.beans.factory.xml.XmlBeanDefinitionReader;
import com.spongehah.utils.StringUtils;

import java.lang.reflect.Method;
import java.util.Iterator;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext{
    
    public ClassPathXmlApplicationContext(String configLocation) {
        this.configLocation = configLocation;
        this.beanDefinitionReader = new XmlBeanDefinitionReader();
        try {
            this.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public Object getBean(String name) throws Exception {
        Object obj = singletonObjects.get(name);
        if (obj != null) {
            return obj;
        }
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        BeanDefinition beanDefinition = registry.getBeanDefinition(name);
        String className = beanDefinition.getClassName();
        Class<?> clazz = Class.forName(className);
        Object beanObj = clazz.newInstance();
        
        //进行依赖注入
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        
        Iterator<PropertyValue> iterator = propertyValues.iterator();
        while (iterator.hasNext()) {
            PropertyValue next = iterator.next();
            String propertyName = next.getName();
            String value = next.getValue();
            String ref = next.getRef();
            if (ref != null && !"".equals(ref)) {
                Object bean = getBean(ref);
                String methodName = StringUtils.getSetterMethodByFieldName(propertyName);
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (method.getName().equals(methodName)) {
                        method.invoke(beanObj, bean);
                    }
                }
            }
            if (value != null && !"".equals(value)) {
                String methodName = StringUtils.getSetterMethodByFieldName(propertyName);
                Method method = clazz.getMethod(methodName, String.class);
                method.invoke(beanObj, value);
            }
        }
        
        /*for (PropertyValue propertyValue : propertyValues) {
            String propertyName = propertyValue.getName();
            String value = propertyValue.getValue();
            String ref = propertyValue.getRef();
            if (ref != null && !"".equals(ref)) {
                Object bean = getBean(ref);
                String methodName = StringUtils.getSetterMethodByFieldName(propertyName);
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (method.getName().equals(methodName)) {
                        method.invoke(beanObj, bean);
                    }
                }
            }
            if (value != null && !"".equals(value)) {
                String methodName = StringUtils.getSetterMethodByFieldName(propertyName);
                Method method = clazz.getMethod(methodName, String.class);
                method.invoke(beanObj, value);
            }
        }*/
        
        singletonObjects.put(name, beanObj);
        return beanObj;
    }

    @Override
    public <T> T getBean(String name, Class<? extends T> clazz) throws Exception {
        Object bean = getBean(name);
        if (bean == null) {
            return null;
        }
        return clazz.cast(bean);
    }
}
