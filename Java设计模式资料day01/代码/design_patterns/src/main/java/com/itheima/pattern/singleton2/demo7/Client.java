package com.itheima.pattern.singleton2.demo7;

import java.io.*;

public class Client {

    public static void main(String[] args) throws Exception {
        // writeObjectToFile();
        readObjectFromFile();
        readObjectFromFile();
        /**
         * 当没有写readResolve方法时：
         * com.itheima.pattern.singleton2.demo7.Singleton@27973e9b
         * com.itheima.pattern.singleton2.demo7.Singleton@312b1dae
         */
    }
    
    private static void writeObjectToFile() throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\zhaoyingjie\\Desktop\\aaa.txt"));

        Singleton instance = Singleton.getInstance();
        oos.writeObject(instance);
        oos.close();

    }
    
    private static void readObjectFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\zhaoyingjie\\Desktop\\aaa.txt"));
        Singleton instance = (Singleton) ois.readObject();
        System.out.println(instance);
        ois.close();
    }
}
