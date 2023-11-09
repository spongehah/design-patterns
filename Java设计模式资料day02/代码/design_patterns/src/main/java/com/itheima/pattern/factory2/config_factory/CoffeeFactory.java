package com.itheima.pattern.factory2.config_factory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CoffeeFactory {
    
    private static Map<String, String> map = new HashMap<>();
    
    static {
        Properties properties = new Properties();
        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean2.properties");
        try {
            properties.load(is);
            Set<Object> keys = properties.keySet();
            for (Object key : keys) {
                String className = properties.getProperty((String) key);
                // Coffee coffee = (Coffee) Class.forName(className).newInstance();
                // map.put((String) key, coffee);
                map.put((String) key,className);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Coffee createCoffee(String name) throws Exception {
        String className = map.get(name);
        return (Coffee) Class.forName(className).newInstance();
    }
}
