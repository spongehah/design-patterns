package com.spongehah.utils;

public class StringUtils {
    
    public static String getSetterMethodByFieldName(String fieldName) {
        return "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
    }
}
    