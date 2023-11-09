package com.itheima.pattern.flyweight2;

import java.util.HashMap;
import java.util.Map;

public class BoxFactory {
    
    private static BoxFactory boxFactory = new BoxFactory();
    
    private static Map<String, AbstractBox> map;
    
    private BoxFactory() {
        map = new HashMap<>();
        map.put("I", new IBox());
        map.put("L", new LBox());
        map.put("O", new OBox());
    }
    
    public static BoxFactory getInstance() {
        return boxFactory;
    }
    
    public AbstractBox getBox(String key) {
        return map.get(key);
    }
    
}
