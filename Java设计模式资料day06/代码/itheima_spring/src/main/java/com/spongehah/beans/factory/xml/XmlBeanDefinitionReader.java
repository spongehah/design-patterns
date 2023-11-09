package com.spongehah.beans.factory.xml;

import com.spongehah.beans.BeanDefinition;
import com.spongehah.beans.MutablePropertyValues;
import com.spongehah.beans.PropertyValue;
import com.spongehah.beans.factory.support.BeanDefinitionReader;
import com.spongehah.beans.factory.support.BeanDefinitionRegistry;
import com.spongehah.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XmlBeanDefinitionReader implements BeanDefinitionReader {
    
    private BeanDefinitionRegistry registry;
    
    public XmlBeanDefinitionReader() {
        this.registry = new SimpleBeanDefinitionRegistry();
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public void loadBeanDefinitions(String configLocation) throws Exception {
        SAXReader reader = new SAXReader();
        InputStream is = XmlBeanDefinitionReader.class.getClassLoader().getResourceAsStream(configLocation);
        Document document = reader.read(is);
        //获取根标签beans
        Element rootElement = document.getRootElement();
        //获取所有bean
        List<Element> beanElements = rootElement.elements("bean");
        for (Element beanElement : beanElements) {
            String id = beanElement.attributeValue("id");
            String className = beanElement.attributeValue("class");

            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setId(id);
            beanDefinition.setClassName(className);

            MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();

            List<Element> propertyElements = beanElement.elements("property");
            for (Element propertyElement : propertyElements) {
                String name = propertyElement.attributeValue("name");
                String ref = propertyElement.attributeValue("ref");
                String value = propertyElement.attributeValue("value");
                PropertyValue propertyValue = new PropertyValue(name, ref, value);
                mutablePropertyValues.addPropertyValue(propertyValue);
            }
            
            beanDefinition.setPropertyValues(mutablePropertyValues);
            
            registry.registerBeanDefinition(id, beanDefinition);
        }
    }
}
